package com.watercooler.dataLayerTests;

import com.watercooler.daos.CompanyJobsDALImp;
import com.watercooler.entities.Applicant;
import com.watercooler.entities.Job;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;


public class CompanyJobsDALTests {
    CompanyJobsDALImp jobsdao = new CompanyJobsDALImp();

   @Test
    public void postJobSuccess(){
       Job testJob = new Job(1, "testTitle", "Management", "testDescription", -1, "testLocation", "testName");
       Job resultingJob = jobsdao.postJob(testJob);
       Assert.assertNotEquals(resultingJob.getJobId(), 0);
   };

   @Test
    public void viewJobsSuccess(){
        List<Job> testJobs = jobsdao.viewJobs(-1);
        Assert.assertTrue(testJobs.size() >= 1);
   };

   @Test
    public void viewApplicantsSuccess(){
       List<Applicant> applicants = jobsdao.viewApplicants(0);
       Assert.assertTrue(applicants.size() >= 1);
   };

   @Test
    public void deleteJobsSuccess(){
        int result = jobsdao.deleteJobs(1);
        Assert.assertTrue(result != 0);
   };
}
