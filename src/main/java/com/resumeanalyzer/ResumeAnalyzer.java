package com.resumeanalyzer;

public class ResumeAnalyzer {
    private final SkillMatcher matcher = new SkillMatcher();

    public AnalysisResult analyze(Resume resume, JobDescription jobDescription) {
        SkillMatcher.MatchResult match =
                matcher.compare(resume.getSkills(), jobDescription.getRequiredSkills());

        return new AnalysisResult(
                resume.getCandidateName(),
                jobDescription.getTitle(),
                resume.getSkills(),
                jobDescription.getRequiredSkills(),
                match.matchedSkills(),
                match.missingSkills(),
                match.score()
        );
    }
}
