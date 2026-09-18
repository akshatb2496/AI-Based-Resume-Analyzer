package com.resumeanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.stream.Collectors;

public class ReportGenerator {

    public void printReport(AnalysisResult result) {
        System.out.println(buildReport(result));
    }

    public void saveReport(AnalysisResult result, Path path) throws IOException {
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }
        Files.writeString(path, buildReport(result));
    }

    private String buildReport(AnalysisResult result) {
        StringBuilder report = new StringBuilder();

        report.append("\n==============================================\n");
        report.append("           RESUME ANALYSIS REPORT\n");
        report.append("==============================================\n");
        report.append("Candidate       : ").append(result.candidateName()).append("\n");
        report.append("Job Title       : ").append(result.jobTitle()).append("\n");

        report.append("\nResume Skills\n");
        report.append("----------------------------------------------\n");
        report.append(formatSet(result.resumeSkills()));

        report.append("\nRequired Skills\n");
        report.append("----------------------------------------------\n");
        report.append(formatSet(result.requiredSkills()));

        report.append("\nMatched Skills\n");
        report.append("----------------------------------------------\n");
        report.append(formatSet(result.matchedSkills()));

        report.append("\nMissing Skills\n");
        report.append("----------------------------------------------\n");
        report.append(formatSet(result.missingSkills()));

        report.append("\nMatch Score\n");
        report.append("----------------------------------------------\n");
        report.append(String.format(Locale.ROOT, "%.2f%%", result.score())).append("\n");

        report.append("\nSuggestions\n");
        report.append("----------------------------------------------\n");

        if (result.missingSkills().isEmpty()) {
            report.append("The resume contains all detected required skills.\n");
        } else {
            result.missingSkills().forEach(skill ->
                    report.append("Consider learning or adding evidence of: ")
                            .append(skill)
                            .append(".\n"));
        }

        report.append("\n==============================================\n");
        report.append("Note: This project uses rule-based text analysis and\n");
        report.append("a predefined skill dictionary. It is not a trained\n");
        report.append("machine-learning model.\n");
        report.append("==============================================\n");

        return report.toString();
    }

    private String formatSet(java.util.Set<String> values) {
        if (values.isEmpty()) {
            return "None detected\n";
        }

        return values.stream()
                .map(skill -> "• " + skill)
                .collect(Collectors.joining("\n", "", "\n"));
    }
}
