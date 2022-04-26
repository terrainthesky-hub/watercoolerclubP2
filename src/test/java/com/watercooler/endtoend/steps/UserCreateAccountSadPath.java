package com.watercooler.endtoend.steps.sadpathsteps;

import com.watercooler.endtoend.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserCreateAccountSadPath {
    @Given("I am on the landing page user create acct")
    public void i_am_on_the_landing_page_user_create_acct() {
        TestRunner.driver.get("file://C:/java/WCCP2/watercoolerclubP2/frontEnd/Lesley/landingPage.html");
    }
    @When("I click on the create new user button create acct")
    public void i_click_on_the_create_new_user_button_create_acct() {
        TestRunner.jobsHome.clickUserCreateButton();
    }

    @When("I am on the create page sadpath")
    public void i_am_on_the_create_page_sadpath(){
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("User Create", title);
    }
    @When("I fill out my username user create enough characters")
    public void i_fill_out_my_username_user_create_enough_characters() {
        TestRunner.jobsHome.sendKeysToUserLogin("Skcubrats");;
    }


    @When("I fill out my password user create with too many characters")
    public void i_fill_out_my_password_user_create_with_too_many_characters()
        {
            TestRunner.jobsHome.sendKeysToUserPassword("Starbucks is too expensive, but it does taste pretty good if you don't mind extra calories coming from a drink");
    }
    @When("I click on the Create User acct button sadpath")
    public void i_click_on_the_create_user_acct_button_sadpath() {
                TestRunner.jobsHome.clickLoginButton();
            }
    @Then("I am given an error alert for incorrect username and password sadpath")
    public void i_am_given_an_error_alert_for_incorrect_username_and_password_sadpath() {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Username and Password need to be more than 6 characters and less than 20",TestRunner.driver.switchTo().alert().getText());
        TestRunner.driver.switchTo().alert().accept();
    }

}
