package com.watercooler.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

//import poms

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "com/watercooler/steps",
        plugin = {"pretty", "html:documentation/e2eReports/skill-tests-e2e-report.html"}
)
public class TestRunner {
    public static WebDriver driver;

    //set poms variables

    @BeforeClass
    public static void setup() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();

        //pass driver into poms

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}
