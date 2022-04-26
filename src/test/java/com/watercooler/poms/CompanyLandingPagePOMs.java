package com.watercooler.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;

public class CompanyLandingPagePOMs {
    private SafariDriver driver;
    private By createJobPostButton = By.id("createJobPostFromHome");
    private By viewPostedJobsButton = By.id("viewPostedJobsFromHome");
    private By editCompanyProfile = By.id("editCompanyProfileFromHome");
    private By manageCompanySkillTests = By.id("manageCompanySkillTestsFromHome");
    private By logOut = By.id("logOutFromCompanyHome");

    public CompanyLandingPagePOMs(SafariDriver driver){
        this.driver = driver;
    }

    public void clickCreateJobPostButton(){
        driver.findElement(createJobPostButton).click();
    }

    public void clickViewPostedJobsButton(){
        driver.findElement(viewPostedJobsButton).click();
    }

    public void clickEditCompanyProfileButton(){
        driver.findElement(editCompanyProfile).click();
    }

    public void clickManageCompanySkillTestsButton(){
        driver.findElement(manageCompanySkillTests).click();
    }

    public void clickLogOut(){
        driver.findElement(logOut).click();
    }
}
