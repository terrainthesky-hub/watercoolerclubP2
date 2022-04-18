package com.watercooler.entities;

import java.util.Objects;

public class UsernamePasswordCompany {
    private int companyId;
    private String companyUsername;
    private String companyPassword;

    public UsernamePasswordCompany() {

    }

    public UsernamePasswordCompany(int companyId, String companyUsername, String companyPassword) {

        this.companyId = companyId;
        this.companyUsername = companyUsername;
        this.companyPassword = companyPassword;

    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyUsername() {
        return companyUsername;
    }

    public void setCompanyUsername(String companyUsername) {
        this.companyUsername = companyUsername;
    }

    public String getCompanyPassword() {
        return companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsernamePasswordCompany that = (UsernamePasswordCompany) o;
        return companyId == that.companyId && Objects.equals(companyUsername, that.companyUsername) && Objects.equals(companyPassword, that.companyPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, companyUsername, companyPassword);
    }

    @Override
    public String toString() {
        return "UsernamePasswordCompany{" +
                "companyId=" + companyId +
                ", companyUsername='" + companyUsername + '\'' +
                ", companyPassword='" + companyPassword + '\'' +
                '}';
    }
}
