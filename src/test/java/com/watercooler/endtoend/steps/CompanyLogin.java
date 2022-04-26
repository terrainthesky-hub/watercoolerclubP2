package com.watercooler.endtoend.steps;

import com.watercooler.endtoend.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompanyLogin {

    @Given("Account is already created and I am on the landing page company login")
    public void account_is_already_created_and_i_am_on_the_landing_page_company_login() {
        TestRunner.driver.get("file://C:/java/WCCP2/watercoolerclubP2/frontEnd/Lesley/landingPage.html");
    }
    @When("I click on the Sign in to an existing company account")
    public void i_click_on_the_sign_in_to_an_existing_company_account() {
        TestRunner.jobsHome.clickCompanyLoginButton();
    }
    @When("I am redirected to the login page company login")
    public void i_am_redirected_to_the_login_page_company_login(){
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Company Login", title);
    }

    @When("I enter my username company login")
    public void i_enter_my_username_company_login() {
        TestRunner.jobsHome.sendKeysToUserLogin("SoySauce");
    }
    @When("I enter my password company login")
    public void i_enter_my_password_company_login() {
            TestRunner.jobsHome.sendKeysToUserPassword("Ambrosia");
    }
    @When("I click on the Login button company login")
    public void i_click_on_the_login_button_company_login() {
        TestRunner.jobsHome.clickLoginButton();
    }
    @Then("I am taken to the jobs page")
    public void i_am_taken_to_the_jobs_page() {
        TestRunner.wait.until(ExpectedConditions.titleIs("Welcome to the void!"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Welcome to the void!", title);
    }

}
