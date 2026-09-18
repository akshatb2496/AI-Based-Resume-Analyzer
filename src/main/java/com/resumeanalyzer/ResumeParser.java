package com.resumeanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResumeParser {

    private static final String[] SKILL_DICTIONARY = {
            "java", "python", "c", "c++", "c#", "javascript", "typescript",
            "html", "css", "sql", "mysql", "postgresql", "mongodb",
            "git", "github", "docker", "kubernetes", "linux",
            "spring boot", "spring", "rest api", "api", "data structures",
            "algorithms", "machine learning", "deep learning", "artificial intelligence",
            "pandas", "numpy", "matplotlib", "tensorflow", "pytorch",
            "react", "angular", "node.js", "node", "aws", "azure",
            "communication", "problem solving"
    };

    public Resume parse(Path path) throws IOException {
        String text = read(path);
        String name = extractName(text);
        return new Resume(name, text, extractSkills(text));
    }

    public JobDescription parseJobDescription(Path path) throws IOException {
        String text = read(path);
        String title = extractTitle(text);
        return new JobDescription(title, text, extractSkills(text));
    }

    private String read(Path path) throws IOException {
        if (!Files.exists(path)) {
            throw new IOException("File not found: " + path);
        }
        return Files.readString(path);
    }

    private String extractName(String text) {
        Pattern pattern = Pattern.compile("(?im)^\\s*name\\s*:\\s*(.+)$");
        Matcher matcher = pattern.matcher(text);
        return matcher.find() ? matcher.group(1).trim() : "Not specified";
    }

    private String extractTitle(String text) {
        Pattern pattern = Pattern.compile("(?im)^\\s*(job title|position|role)\\s*:\\s*(.+)$");
        Matcher matcher = pattern.matcher(text);
        return matcher.find() ? matcher.group(2).trim() : "Not specified";
    }

    private Set<String> extractSkills(String text) {
        String normalized = text.toLowerCase(Locale.ROOT);
        Set<String> found = new LinkedHashSet<>();

        for (String skill : SKILL_DICTIONARY) {
            String escaped = Pattern.quote(skill.toLowerCase(Locale.ROOT));
            String regex = "(?<![a-z0-9+#])" + escaped + "(?![a-z0-9+#])";
            if (Pattern.compile(regex).matcher(normalized).find()) {
                found.add(skill);
            }
        }

        return found;
    }
}
