package com.watercooler.steps;

import com.watercooler.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TakeSkillTestSteps {
//some steps have already been created in CreateSkillTestSteps

    @When("I input my {string}")
    public void i_input_my(String string) {
        TestRunner.landingPage.inputIndividualId(string);
    }

    @When("I click on the Take Skill Tests button")
    public void i_click_on_the_take_skill_tests_button() {
        TestRunner.landingPage.clickViewTestsButton();
    }

    @When("I am on the skill tests page")
    public void i_am_on_the_skill_tests_page() {
        TestRunner.wait.until(ExpectedConditions.titleIs("View Skill Tests"));
    }

    @When("I click on test {string} button")
    public void i_click_on_test_button(String string) {
        TestRunner.viewSkillTests.selectSpecificSkillTest(string);
    }

    @When("I am on that skill test's page with {string}")
    public void i_am_on_that_skill_test_s_page(String string) {
        TestRunner.wait.until(ExpectedConditions.titleIs("Take Skill Test"));
        TestRunner.wait.until(ExpectedConditions.textToBe(TestRunner.takeSkillTest.questionOne, string));
    }

    @When("I fill out the {string} 1A")
    public void i_fill_out_the_1A(String string) {
        TestRunner.takeSkillTest.submitAnswerOne(string);
    }

    @When("I fill out the {string} 2A")
    public void i_fill_out_the_2A(String string) {
        TestRunner.takeSkillTest.submitAnswerTwo(string);
    }

    @When("I fill out the {string} 3A")
    public void i_fill_out_the_3A(String string) {
        TestRunner.takeSkillTest.submitAnswerThree(string);
    }

    @When("I click the submit button")
    public void i_click_the_submit_button() {
        TestRunner.takeSkillTest.submitTest();
    }

    @When("I get an alert that tells me that I passed")
    public void i_get_an_alert_that_tells_me_that_i_passed() {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(TestRunner.driver.switchTo().alert().getText(), "You passed the test!");
        TestRunner.driver.switchTo().alert().accept();
    }

    @When("I fill out the first answer incorrectly")
    public void i_fill_out_the_first_answer_incorrectly() {
        TestRunner.takeSkillTest.submitAnswerOne("this is an incorrect answer");
    }

    @When("I get an alert that tells me that I failed")
    public void i_get_an_alert_that_tells_me_that_i_failed() {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(TestRunner.driver.switchTo().alert().getText(), "You did not pass the test.");
        TestRunner.driver.switchTo().alert().accept();
    }

    @Then("I am on the skill tests page 2")
    public void i_am_on_the_skill_tests_page_2() {
        TestRunner.wait.until(ExpectedConditions.titleIs("View Skill Tests"));
    }
}
