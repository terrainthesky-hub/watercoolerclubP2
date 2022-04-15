package com.watercooler.dataLayerTests;

import com.watercooler.daos.CompanyJobsDALImp;
import com.watercooler.entities.Applicant;
import com.watercooler.entities.Job;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;


public class CompanyJobsDALTests {
    CompanyJobsDALImp jobsDAO = new CompanyJobsDALImp();

   @Test
    public void postJobSuccess(){
       Job testJob = new Job(1, "testTitle", "management", "testDescription", -1, "testLocation", "testName");
       Job resultingJob = jobsDAO.postJob(testJob);
       Assert.assertNotEquals(resultingJob.getJobId(), 0);
   };

   @Test
    public void viewJobsSuccess(){
        List<Job> testJobs = jobsDAO.viewJobs(-1);
        Assert.assertTrue(testJobs.size() >= 1);
   };

   @Test
    public void viewApplicantsSuccess(){
       List<Applicant> applicants = jobsDAO.viewApplicants(0);
       Assert.assertTrue(applicants.size() >= 1);
   };

   @Test
    public void deleteJobsSuccess(){
        int result = jobsDAO.deleteJobs(1);
        Assert.assertTrue(result != 0);
   };
}
