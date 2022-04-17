package com.watercooler.serviceLayerTests;

import com.watercooler.daos.CompanyJobsDALImp;
import com.watercooler.entities.Applicant;
import com.watercooler.entities.Job;
import com.watercooler.saos.CompanyJobsSALImp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CompanyJobsSALTests {
    CompanyJobsDALImp jobsDAO = new CompanyJobsDALImp();
    CompanyJobsSALImp jobsSAO = new CompanyJobsSALImp(jobsDAO);

    // need to write tests for empty fields

    @Test
    public void servicePostJobSuccess(){
        Job testJob = new Job(1, "testTitle", "management", "testDescription", -1, "testLocation", "testName");
        Job result = jobsSAO.servicePostJob(testJob);
        Assert.assertNotEquals(result.getJobId(), 0);
    };

    @Test
    public void servicePostJobTitleTooLong(){
        Job testJob = new Job(1, "thisiswaytoolongtopassintothedatabase", "management", "testDescription", -1, "testLocation", "testName");
        Job result = jobsSAO.servicePostJob(testJob);
        Assert.assertNotEquals(result, false, "Job title is too long!");

    };

    @Test
    public void servicePostJobTypeTooLong(){
        Job testJob = new Job(1, "testTitle", "thisiswaytoolongtopassintothedatabase", "testDescription", -1, "testLocation", "testName");
        Job result = jobsSAO.servicePostJob(testJob);
        Assert.assertNotEquals(result, false, "Job type is too long!");

    };

    @Test
    public void servicePostJobDescriptionTooLong(){
        Job testJob = new Job(1, "testTitle", "management", "thisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabase", -1, "testLocation", "testName");
        Job result = jobsSAO.servicePostJob(testJob);
        Assert.assertNotEquals(result, false, "Job description is too long!");
    };

    // need to write test for company id being anything other than an int and implement

    @Test
    public void servicePostJobLocationTooLong(){
        Job testJob = new Job(1, "testTitle", "management", "testDescription", -1, "thisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabase", "testName");
        Job result = jobsSAO.servicePostJob(testJob);
        Assert.assertNotEquals(result, false, "Job location is too long!");
    };

    @Test
    public void servicePostJobCompanyNameTooLong(){
        Job testJob = new Job(1, "testTitle", "management", "testDescription", -1, "testLocation", "thisiswaytoolongtopassintothedatabasethisiswaytoolongtopassintothedatabase");
        Job result = jobsSAO.servicePostJob(testJob);
        Assert.assertNotEquals(result, false, "Company name is too long!");
    };

    @Test
    public void serviceViewPostedJobsSuccess(){
        List<Job> testJobList = jobsSAO.serviceViewJobs(0);
        Assert.assertTrue(testJobList.size() >= 1);
    };

    @Test
    public void serviceViewPostedJobsNoPostedJobs(){
        List<Job> testList = jobsSAO.serviceViewJobs(-2);
        Assert.assertFalse(testList.size() <= 0, "There are no posted jobs with the company ID provided!");
    };

    @Test
    public void serviceViewApplicantsSuccess(){
        List<Applicant> applicants = jobsSAO.serviceViewApplicants(0);
        Assert.assertTrue(applicants.size() >= 1);
    };

    @Test
    public void serviceViewApplicantsNoJobToViewApplicants(){
        List<Applicant> applicants = jobsSAO.serviceViewApplicants(-1);
        Assert.assertFalse(applicants.size() <= 0, "There are no applicants for the job ID provided!");
    };

    @Test
    public void serviceDeleteJobsSuccess(){
        int result = jobsSAO.serviceDeleteJobs(1);
        Assert.assertTrue(result != 0);
    };

    @Test
    public void serviceDeleteJobsNoJobToDelete(){
        int result = jobsSAO.serviceDeleteJobs(-500);
        Assert.assertFalse(result == 0, "There are no jobs to delete with the job ID provided!");
    };

}
