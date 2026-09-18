package com.resumeanalyzer;

import java.util.Collections;
import java.util.Set;

public class Resume {
    private final String candidateName;
    private final String text;
    private final Set<String> skills;

    public Resume(String candidateName, String text, Set<String> skills) {
        this.candidateName = candidateName;
        this.text = text;
        this.skills = skills;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getText() {
        return text;
    }

    public Set<String> getSkills() {
        return Collections.unmodifiableSet(skills);
    }
}
