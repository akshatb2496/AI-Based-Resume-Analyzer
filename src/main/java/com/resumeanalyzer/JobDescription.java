package com.resumeanalyzer;

import java.util.Collections;
import java.util.Set;

public class JobDescription {
    private final String title;
    private final String text;
    private final Set<String> requiredSkills;

    public JobDescription(String title, String text, Set<String> requiredSkills) {
        this.title = title;
        this.text = text;
        this.requiredSkills = requiredSkills;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Set<String> getRequiredSkills() {
        return Collections.unmodifiableSet(requiredSkills);
    }
}
