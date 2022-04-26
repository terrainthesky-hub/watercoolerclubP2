package com.watercooler.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateSkillTestHome {
    private WebDriver driver;

    private By questionOne = By.id("question-one");
    private By answerOne = By.id("answer-one");
    private By questionTwo = By.id("question-two");
    private By answerTwo = By.id("answer-two");
    private By questionThree = By.id("question-three");
    private By answerThree = By.id("answer-three");
    private By submitButton = By.id("submit-test-button");

    public CreateSkillTestHome(WebDriver driver) {
        this.driver = driver;
    }

    public void inputQuestionOne(String inputQuestionOne) {
        driver.findElement(questionOne).sendKeys(inputQuestionOne);
    }

    public void inputAnswerOne(String inputAnswerOne) {
        driver.findElement(answerOne).sendKeys(inputAnswerOne);
    }

    public void inputQuestionTwo(String inputQuestionTwo) {
        driver.findElement(questionTwo).sendKeys(inputQuestionTwo);
    }

    public void inputAnswerTwo(String inputAnswerTwo) {
        driver.findElement(answerTwo).sendKeys(inputAnswerTwo);
    }

    public void inputQuestionThree(String inputQuestionThree) {
        driver.findElement(questionThree).sendKeys(inputQuestionThree);
    }

    public void inputAnswerThree(String inputAnswerThree) {
        driver.findElement(answerThree).sendKeys(inputAnswerThree);
    }

    public void submitTest() {
        driver.findElement(submitButton).click();
    }
}