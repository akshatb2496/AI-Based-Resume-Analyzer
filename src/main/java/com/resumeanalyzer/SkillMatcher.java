package com.resumeanalyzer;

import java.util.LinkedHashSet;
import java.util.Set;

public class SkillMatcher {

    public MatchResult compare(Set<String> resumeSkills, Set<String> requiredSkills) {
        Set<String> matched = new LinkedHashSet<>();
        Set<String> missing = new LinkedHashSet<>();

        for (String required : requiredSkills) {
            if (resumeSkills.contains(required)) {
                matched.add(required);
            } else {
                missing.add(required);
            }
        }

        double score = requiredSkills.isEmpty()
                ? 0.0
                : (matched.size() * 100.0) / requiredSkills.size();

        return new MatchResult(matched, missing, score);
    }

    public record MatchResult(
            Set<String> matchedSkills,
            Set<String> missingSkills,
            double score
    ) {}
}
