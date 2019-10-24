package com.company.resume.models;

import java.io.Serializable;

public class ResumeComponent implements Serializable {
    private String title;
    private String content;

    public ResumeComponent() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
