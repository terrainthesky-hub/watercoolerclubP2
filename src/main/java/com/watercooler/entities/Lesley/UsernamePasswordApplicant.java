package com.watercooler.entities.Lesley;

import java.util.Objects;

public class UsernamePasswordApplicant {

    private int applicantId;
    private String applicantUsername;
    private String applicantPassword;

    public UsernamePasswordApplicant() {

    }

    public UsernamePasswordApplicant(int applicantId, String applicantUsername, String applicantPassword){

        this.applicantId = applicantId;
        this.applicantUsername = applicantUsername;
        this.applicantPassword = applicantPassword;

    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantUsername() {
        return applicantUsername;
    }

    public void setApplicantUsername(String applicantUsername) {
        this.applicantUsername = applicantUsername;
    }

    public String getApplicantPassword() {
        return applicantPassword;
    }

    public void setApplicantPassword(String applicantPassword) {
        this.applicantPassword = applicantPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsernamePasswordApplicant that = (UsernamePasswordApplicant) o;
        return applicantId == that.applicantId && Objects.equals(applicantUsername, that.applicantUsername) && Objects.equals(applicantPassword, that.applicantPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicantId, applicantUsername, applicantPassword);
    }

    @Override
    public String toString() {
        return "UsernamePasswordApplicant{" +
                "applicantId=" + applicantId +
                ", applicantUsername='" + applicantUsername + '\'' +
                ", applicantPassword='" + applicantPassword + '\'' +
                '}';
    }
}
