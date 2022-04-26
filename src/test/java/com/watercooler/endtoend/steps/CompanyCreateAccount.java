package com.watercooler.endtoend.steps;

import com.watercooler.endtoend.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompanyCreateAccount {

    @Given("I am on the landing page create account")
    public void i_am_on_the_landing_page_create_account() {
        TestRunner.driver.get("file://C:/java/WCCP2/watercoolerclubP2/frontEnd/Lesley/landingPage.html");
    }
    @When("I click on the create new company button")
    public void i_click_on_the_create_new_company_button() {
        TestRunner.jobsHome.clickCompanyCreateButton();
    }
    @When("I am on the create company page")
    public void i_am_on_the_create_company_page() {
        TestRunner.wait.until(ExpectedConditions.titleIs("Company Create"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Company Create", title);
    }
    @When("I fill out my username create account")
    public void i_fill_out_my_username_create_account() {
        TestRunner.jobsHome.sendKeysToUserLogin("SoySauce");
    }
    @When("I fill out my password create account")
    public void i_fill_out_my_password_create_account() {
        TestRunner.jobsHome.sendKeysToUserPassword("Ambrosia");
    }
    @When("I click on the Create Company Account button")
    public void i_click_on_the_create_company_account_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.jobsHome.clickLoginButton();
    }

    @When("I click on an alert about successful account creation create account")
    public void i_click_on_an_alert_about_successful_account_creation_create_account() {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("You've successfully created a company account",TestRunner.driver.switchTo().alert().getText());
        TestRunner.driver.switchTo().alert().accept();

    }


    @Then("My Company account should be created")
    public void my_company_account_should_be_created() {
        TestRunner.wait.until(ExpectedConditions.titleIs("Welcome to the void!"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Welcome to the void!", title);

    }

}
