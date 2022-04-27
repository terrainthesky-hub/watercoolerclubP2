package com.watercooler.entities;

import java.util.Objects;

public class Applicant {
    private int id;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String email;
    private String workHistory;
    private String references;
    private String education;
    private String desiredJob;

    public Applicant() {

    }

    public Applicant(int id, String firstName, String lastName, long phoneNumber, String email, String workHistory, String references, String education, String desiredJob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.workHistory = workHistory;
        this.references = references;
        this.education = education;
        this.desiredJob = desiredJob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkHistory() { return workHistory; }

    public void setWorkHistory(String workHistory) { this.workHistory = workHistory; }

    public String getReferences() { return references; }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDesiredJob() { return desiredJob; }

    public void setDesiredJob(String desiredJob) { this.desiredJob = desiredJob; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applicant applicant = (Applicant) o;
        return id == applicant.id && phoneNumber == applicant.phoneNumber && Objects.equals(firstName, applicant.firstName) && Objects.equals(lastName, applicant.lastName) && Objects.equals(email, applicant.email) && Objects.equals(workHistory, applicant.workHistory) && Objects.equals(references, applicant.references) && Objects.equals(education, applicant.education) && Objects.equals(desiredJob, applicant.desiredJob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, email, workHistory, references, education, desiredJob);
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", workHistory='" + workHistory + '\'' +
                ", references='" + references + '\'' +
                ", education='" + education + '\'' +
                ", desiredJob='" + desiredJob + '\'' +
                '}';
    }
}