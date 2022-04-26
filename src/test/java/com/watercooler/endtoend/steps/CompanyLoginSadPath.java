package com.watercooler.endtoend.steps.sadpathsteps;

import com.watercooler.endtoend.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompanyLoginSadPath {
    @Given("Acct is already created and I am on the landing page company login")
    public void acct_is_already_created_and_i_am_on_the_landing_page_company_login() {
        TestRunner.driver.get("file://C:/java/WCCP2/watercoolerclubP2/frontEnd/Lesley/landingPage.html");
    }
    @When("I click on the Sign in to an existing company acct")
    public void i_click_on_the_sign_in_to_an_existing_company_acct() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.jobsHome.clickCompanyLoginButton();
    }
    @When("I am redirected to the login acct page company login")
    public void i_am_redirected_to_the_login_acct_page_company_login() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Company Login", title);
    }
    @When("I enter my username company login with too many characters")
    public void i_enter_my_username_company_login_with_too_many_characters() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.jobsHome.sendKeysToUserLogin("SoySauce is the ambrosia of the masses, but tonkotsu ramen is better");
    }
    @When("I enter my password company login acct")
    public void i_enter_my_password_company_login_acct() {
        {
            TestRunner.jobsHome.sendKeysToUserPassword("Ambrosia");
        }
    }
    @Then("I am given a warning about there  being too few characters in username and password")
    public void i_am_given_a_warning_about_there_being_too_few_characters_in_username_and_password() {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Incorrect Username or Password",TestRunner.driver.switchTo().alert().getText());
        TestRunner.driver.switchTo().alert().accept();
    }
}
