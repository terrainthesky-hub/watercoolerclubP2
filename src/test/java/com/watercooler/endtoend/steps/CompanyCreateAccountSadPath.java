package com.watercooler.endtoend.steps.sadpathsteps;

import com.watercooler.endtoend.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompanyCreateAccountSadPath {

    @Given("I am on the landing page comp acct")
    public void i_am_on_the_landing_page_comp_acct() {
        TestRunner.driver.get("file://C:/java/WCCP2/watercoolerclubP2/frontEnd/Lesley/landingPage.html");
    }
    @When("I click on the create new comp button")
    public void i_click_on_the_create_new_comp_button() {
        TestRunner.jobsHome.clickCompanyCreateButton();
        }
    @When("I am on the create company acct page")
    public void i_am_on_the_create_company_acct_page() {
        TestRunner.wait.until(ExpectedConditions.titleIs("Company Create"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Company Create", title);
    }
    @When("I fill out my username create acct with too few characters")
    public void i_fill_out_my_username_create_acct_with_too_few_characters() {
            TestRunner.jobsHome.sendKeysToUserLogin("Soy");
    }
    @When("I fill out my password create acct")
    public void i_fill_out_my_password_create_acct() {
        {
            TestRunner.jobsHome.sendKeysToUserPassword("Ambrosia");
        }
    }
    @When("I click on the Create Company acct button")
    public void i_click_on_the_create_company_acct_button() {
        TestRunner.jobsHome.clickLoginButton();
    }
    @Then("I get a warning about username and password being too few")
    public void i_get_a_warning_about_username_and_password_being_too_few() {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Username and Password need to be more than 6 characters and less than 20",TestRunner.driver.switchTo().alert().getText());
        TestRunner.driver.switchTo().alert().accept();
    }

}
