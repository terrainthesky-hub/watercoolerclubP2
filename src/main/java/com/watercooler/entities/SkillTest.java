package com.watercooler.entities;

import java.util.Objects;

public class SkillTest {
    private int testId;
    private String questionOne;
    private String answerOne;
    private String questionTwo;
    private String answerTwo;
    private String questionThree;
    private String answerThree;
    private int companyId;

    SkillTest() {

    }

    SkillTest(int testId, String questionOne, String answerOne, String questionTwo, String answerTwo, String questionThree, String answerThree, int companyId){
        this.testId = testId;
        this.questionOne = questionOne;
        this.answerOne = answerOne;
        this.questionTwo = questionTwo;
        this.answerTwo = answerTwo;
        this.questionThree = questionThree;
        this.answerThree = answerThree;
        this.companyId = companyId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public void setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public void setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }

    public String getQuestionThree() {
        return questionThree;
    }

    public void setQuestionThree(String questionThree) {
        this.questionThree = questionThree;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public void setAnswerThree(String answerThree) {
        this.answerThree = answerThree;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillTest skillTest = (SkillTest) o;
        return testId == skillTest.testId && companyId == skillTest.companyId && Objects.equals(questionOne, skillTest.questionOne) && Objects.equals(answerOne, skillTest.answerOne) && Objects.equals(questionTwo, skillTest.questionTwo) && Objects.equals(answerTwo, skillTest.answerTwo) && Objects.equals(questionThree, skillTest.questionThree) && Objects.equals(answerThree, skillTest.answerThree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testId, questionOne, answerOne, questionTwo, answerTwo, questionThree, answerThree, companyId);
    }

    @Override
    public String toString() {
        return "SkillTest{" +
                "testId=" + testId +
                ", questionOne='" + questionOne + '\'' +
                ", answerOne='" + answerOne + '\'' +
                ", questionTwo='" + questionTwo + '\'' +
                ", answerTwo='" + answerTwo + '\'' +
                ", questionThree='" + questionThree + '\'' +
                ", answerThree='" + answerThree + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
