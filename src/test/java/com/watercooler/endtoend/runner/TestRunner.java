package com.watercooler.endtoend.runner;

import com.watercooler.endtoend.poms.JobsHome;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/watercooler/endtoend/features"},
        glue = {"com/watercooler/endtoend/steps"},
        plugin = {"pretty","html:src/test/java/e2eReport/html-e2e-report.html"}

)
public class TestRunner {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JobsHome jobsHome;

    @BeforeClass
    public static void setup(){
        // use the three lines below to set your driver
        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();

        // don't forget to pass your driver into your poms

        // make sure to set your implicit wait and any explicit waits you need
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        jobsHome = new JobsHome(driver);
    }

    // don't forget to quit your driver when you are done
    @AfterClass
    public static void teardown(){
        driver.quit();
    }

}

