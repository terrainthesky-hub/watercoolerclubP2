package com.watercooler.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateJobPostPOMs {
    private WebDriver driver;
    private By jobIdInput = By.id("jobIdInput");
    private By jobTitleInput = By.id("jobTitleInput");
    private By jobTypeInput = By.id("jobTypeInput");
    private By jobDescriptionInput = By.id("jobDescriptionInput");
    private By companyIdInput = By.id("companyIdInput");
    private By jobLocationInput = By.id("jobLocationInput");
    private By companyNameInput = By.id("companyNameInput");
    private By createJobPostButton = By.id("postJobButton");

    public CreateJobPostPOMs(WebDriver driver){
        this.driver = driver;
    }

    public void inputJobId(String jobId){
        driver.findElement(jobIdInput).sendKeys(jobId);
    }

    public void inputJobTitle(String title){
        driver.findElement(jobTitleInput).sendKeys(title);
    }

    public void inputJobType(String type){
        driver.findElement(jobTypeInput).sendKeys(type);
    }

    public void inputJobDescription(String description){
        driver.findElement(jobDescriptionInput).sendKeys(description);
    }

    public void inputCompanyId(String companyId){
        driver.findElement(companyIdInput).sendKeys(companyId);
    }

    public void inputJobLocation(String location){
        driver.findElement(jobLocationInput).sendKeys(location);
    }

    public void inputCompanyName(String companyName){
        driver.findElement(companyNameInput).sendKeys(companyName);
    }

    public void clickCreateJobPostButton(){
        driver.findElement(createJobPostButton).click();
    }
}
