package com.watercooler.entities;

import java.util.Objects;

public class

Job {
    private int jobId;
    private String title;
    private String type;
    private String description;
    private int companyId;
    private String location;
    private String companyName;

    public Job() {

    }

    public Job(int jobId, String title, String type, String description, int companyId, String location, String companyName) {
        this.jobId = jobId;
        this.title = title;
        this.type = type;
        this.description = description;
        this.companyId = companyId;
        this.location = location;
        this.companyName = companyName;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return jobId == job.jobId && companyId == job.companyId && Objects.equals(title, job.title) && Objects.equals(type, job.type) && Objects.equals(description, job.description) && Objects.equals(location, job.location) && Objects.equals(companyName, job.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, title, type, description, companyId, location, companyName);
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", companyId=" + companyId +
                ", location='" + location + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
