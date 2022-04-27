package com.watercooler.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TakeSkillTestHome {
    private WebDriver driver;

    public By questionOne = By.id("question-one");
    private By answerOne = By.id("answer-one");
    private By questionTwo = By.id("question-two");
    private By answerTwo = By.id("answer-two");
    private By questionThree = By.id("question-three");
    private By answerThree = By.id("answer-three");

    private By submitButton = By.id("submit-button");

    public TakeSkillTestHome(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getQuestionOne() {
        WebElement element = driver.findElement(questionOne);
        return element;
    }

    public void submitAnswerOne(String answer) {
        driver.findElement(answerOne).sendKeys(answer);
    }

    public WebElement getQuestionTwo() {
        WebElement element = driver.findElement(questionTwo);
        return element;
    }

    public void submitAnswerTwo(String answer) {
        driver.findElement(answerTwo).sendKeys(answer);
    }

    public WebElement getQuestionThree() {
        WebElement element = driver.findElement(questionThree);
        return element;
    }

    public void submitAnswerThree(String answer) {
        driver.findElement(answerThree).sendKeys(answer);
    }

    public void submitTest() {
        driver.findElement(submitButton).click();
    }
}
