package com.watercooler.runner;

import com.watercooler.poms.CompanyLandingPagePOMs;
import com.watercooler.poms.CreateJobPostPOMs;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "com/watercooler/steps",
        plugin = {"pretty", "html:documentation/e2eReports/managingJobPostse2eReport.html"}
)
public class ManagingJobsRunner {
    public static SafariDriver driver;
    public static CreateJobPostPOMs createJob;
    public static CompanyLandingPagePOMs landingPage;

    @BeforeClass
    public static void setup(){
        SafariDriver driver = new SafariDriver();
        landingPage = new CompanyLandingPagePOMs(driver);
        createJob = new CreateJobPostPOMs(driver);
        // need to add manageJobs pom here and above
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
