package com.watercooler.endtoend.steps;

import com.watercooler.endtoend.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserCreateAccount {

    @Given("I am on the landing page user create")
    public void i_am_on_the_landing_page_user_create() {
        TestRunner.driver.get("file://C:/java/WCCP2/watercoolerclubP2/frontEnd/Lesley/landingPage.html");
    }
    @When("I click on the create new user button create")
    public void i_click_on_the_create_new_user_button_create() {
        TestRunner.jobsHome.clickUserCreateButton();
    }
    @When("I am on the create page")
    public void i_am_on_the_create_page() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("User Create", title);
    }
    @When("I fill out my username user create")
    public void i_fill_out_my_username_user_create() {
        TestRunner.jobsHome.sendKeysToUserLogin("Skcubrats");;
    }
    @When("I fill out my password user create")
    public void i_fill_out_my_password_user_create() {
        TestRunner.jobsHome.sendKeysToUserPassword("Starbucks");
    }
    @When("I click on the Create User Account button")
    public void i_click_on_the_create_user_account_button() {
        TestRunner.jobsHome.clickLoginButton();
    }
    @When("I click on an alert about successful account creation")
    public void i_click_on_an_alert_about_successful_account_creation() {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("You've successfully created a user account",TestRunner.driver.switchTo().alert().getText());
        TestRunner.driver.switchTo().alert().accept();
    }
    @Then("My user account should be created")
    public void my_user_account_should_be_created() {
        TestRunner.wait.until(ExpectedConditions.titleIs("Welcome to the void!"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Welcome to the void!", title);
    }

}
