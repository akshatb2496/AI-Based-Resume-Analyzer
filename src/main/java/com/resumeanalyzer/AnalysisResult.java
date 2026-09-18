package com.resumeanalyzer;

import java.util.Collections;
import java.util.Set;

public record AnalysisResult(
        String candidateName,
        String jobTitle,
        Set<String> resumeSkills,
        Set<String> requiredSkills,
        Set<String> matchedSkills,
        Set<String> missingSkills,
        double score
) {
    public AnalysisResult {
        resumeSkills = Collections.unmodifiableSet(resumeSkills);
        requiredSkills = Collections.unmodifiableSet(requiredSkills);
        matchedSkills = Collections.unmodifiableSet(matchedSkills);
        missingSkills = Collections.unmodifiableSet(missingSkills);
    }
}
