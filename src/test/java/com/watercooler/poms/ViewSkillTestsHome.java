package com.watercooler.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewSkillTestsHome {
    private WebDriver driver;

    private By skillTestButton;

    public ViewSkillTestsHome(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSpecificSkillTest(int testId) {
        skillTestButton = By.id("skillTest" + testId);
        driver.findElement(skillTestButton).click();
    }
}
