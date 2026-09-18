package com.resumeanalyzer;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("        AI-BASED RESUME ANALYZER");
        System.out.println("==============================================");

        Path defaultResume = Path.of("src", "main", "resources", "resume.txt");
        Path defaultJob = Path.of("src", "main", "resources", "job-description.txt");

        System.out.println("\nPress Enter to use the sample resume and job description.");
        System.out.println("Or enter a custom file path.");

        System.out.print("\nResume file [" + defaultResume + "]: ");
        String resumeInput = scanner.nextLine().trim();
        Path resumePath = resumeInput.isEmpty() ? defaultResume : Path.of(resumeInput);

        System.out.print("Job description file [" + defaultJob + "]: ");
        String jobInput = scanner.nextLine().trim();
        Path jobPath = jobInput.isEmpty() ? defaultJob : Path.of(jobInput);

        try {
            ResumeParser parser = new ResumeParser();
            Resume resume = parser.parse(resumePath);
            JobDescription jobDescription = parser.parseJobDescription(jobPath);

            ResumeAnalyzer analyzer = new ResumeAnalyzer();
            AnalysisResult result = analyzer.analyze(resume, jobDescription);

            ReportGenerator reportGenerator = new ReportGenerator();
            reportGenerator.printReport(result);
            reportGenerator.saveReport(result, Path.of("output", "analysis-report.txt"));

            System.out.println("\nReport saved to: output/analysis-report.txt");
        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
            System.out.println("Please check that the input files exist and contain readable text.");
        } finally {
            scanner.close();
        }
    }
}
