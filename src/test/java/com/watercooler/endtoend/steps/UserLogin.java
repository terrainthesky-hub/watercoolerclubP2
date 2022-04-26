package com.watercooler.endtoend.steps;

import com.watercooler.endtoend.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserLogin {

    @Given("Account is already created and I am on the landing page for user")
    public void account_is_already_created_and_i_am_on_the_landing_page_for_user() {
        TestRunner.driver.get("file://C:/java/WCCP2/watercoolerclubP2/frontEnd/Lesley/landingPage.html");
    }
    @When("I click on the sign in to an existing user account")
    public void i_click_on_the_sign_in_to_an_existing_user_account() {
        TestRunner.jobsHome.clickUserLoginButton();
    }
    @When("I am redirected to the login page login")
    public void i_am_redirected_to_the_login_page_login() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("User Login", title);
    }
    @When("I enter my username user login")
    public void i_enter_my_username_user_login() {
        TestRunner.jobsHome.sendKeysToUserLogin("Coloniel");
    }
    @When("I enter my password user login")
    public void i_enter_my_password_user_login() {
        TestRunner.jobsHome.sendKeysToUserPassword("Popeyes");
    }
    @When("I click on the Login button user login")
    public void i_click_on_the_login_button_user_login() {
        TestRunner.jobsHome.clickLoginButton();
    }
    @Then("I am taken to the jobs page user login")
    public void i_am_taken_to_the_jobs_page_user_login() {
        TestRunner.wait.until(ExpectedConditions.titleIs("Welcome to the void!"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Welcome to the void!", title);
    }

}
