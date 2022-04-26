package com.watercooler.endtoend.steps;

import com.watercooler.endtoend.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserLoginSadPath {
    @Given("Account is already created and I am on the landing page user login")
    public void account_is_already_created_and_i_am_on_the_landing_page_user_login(){
        TestRunner.driver.get("file://C:/java/WCCP2/watercoolerclubP2/frontEnd/Lesley/landingPage.html");
    }
    @When("I click on the Sign in to an existing user acct login")
    public void i_click_on_the_sign_in_to_an_existing_user_acct_login() {
        TestRunner.jobsHome.clickUserLoginButton();
    }
    @When("I am redirected to the login page user acct login")
    public void i_am_redirected_to_the_login_page_user_acct_login() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("User Login", title);
    }
    @When("I enter my username user acct login")
    public void i_enter_my_username_user_acct_login() {
        TestRunner.jobsHome.sendKeysToUserLogin("Coloniel");
    }
    @When("I enter my password user acct login too few characters")
    public void i_enter_my_password_user_acct_login_too_few_characters() {
        TestRunner.jobsHome.sendKeysToUserPassword("Pop");
    }
    @Then("I am given an alert about my username and password login having too few characters")
    public void i_am_given_an_alert_about_my_username_and_password_login_having_too_few_characters() {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Incorrect Username or Password",TestRunner.driver.switchTo().alert().getText());
        TestRunner.driver.switchTo().alert().accept();
    }
}
