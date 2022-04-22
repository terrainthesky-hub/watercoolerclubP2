package com.watercooler.serviceLayerTests;

import com.watercooler.daos.JobSearchDAOImp;
import com.watercooler.entities.Job;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class JobSearchSLTest {

   package com.watercooler.serviceLayerTests;

import com.watercooler.entities.Job;
import com.watercooler.utilities.customExceptions.EmptyInput;
import com.watercooler.utilities.customExceptions.NoApplicants;
import com.watercooler.utilities.customExceptions.NoJobFound;
package com.watercooler.dataLayerTests;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.watercooler.daos.JobSearchDAOImp;
import com.watercooler.entities.Job;
import java.util.List;

//    @Test
//    public void placeApplicantServiceSuccess() {
//        Mockito.doReturn(1).when(skillTestDAO).placePassingApplicant(-1, -1);
//        boolean result = skillTestSAO.placePassingApplicant(-1, -1);
//        Assert.assertTrue(result);

//        @Test
//        public void selectJobSuccess() {
            Mockito.doReturn(1).when(JobSearchDAO).selectJob("testLocation2", "Technology");
            boolean result = JobSearchDAO.selectJob("", "")
//            List<Job> jobList = jobSearchDAO.selectJob("testLocation2", "Technology");
//            Assert.assertNotEquals(jobList.size(), 0);

//    From Zach's Skills Test - Mocking Examples'
//    @BeforeClass
//    public void setup() {
//        skillTestDAO = Mockito.mock(SkillTestDAOImp.class);
//        skillTestSAO = new SkillTestSAOImp(skillTestDAO);
//        mockList.add(mockTest);
//    }
//
//    @Test
//    public void getAllTestsServiceSuccess() {
//        Mockito.doReturn(mockList).when(skillTestDAO).getAllSkillTests();
//        HashMap<Integer, String> resultMap = skillTestSAO.getAllSkillTests();
//        Assert.assertEquals(resultMap.get(-1), "test");
//    }
//
//    @Test
//    public void getSpecificTestServiceSuccess() {
//        Mockito.doReturn(mockTest).when(skillTestDAO).getSpecificSkillTest(-1);
//        SkillTest test = skillTestSAO.getSpecificSkillTest(-1);
//        Assert.assertEquals(test, mockTest);
//    }
//
//    @Test
//    public void placeApplicantServiceSuccess() {
//        Mockito.doReturn(1).when(skillTestDAO).placePassingApplicant(-1, -1);
//        boolean result = skillTestSAO.placePassingApplicant(-1, -1);
//        Assert.assertTrue(result);



//From Jeryl's JobSearch DAO tests'

//    public class JobSearchDAOTest {
//
//        JobSearchDAOImp jobSearchDAO = new JobSearchDAOImp();
//
//        @Test
//        public void selectJobSuccess() {
//            List<Job> jobList = jobSearchDAO.selectJob("testLocation2", "Technology");
//            Assert.assertNotEquals(jobList.size(), 0);
//
//        }
//    From Dylan's Post Success example'
//    @Test
//        public void servicePostJobSuccess(){
//            Job testJob = new Job(8, "testTitle", "management", "testDescription", -1, "testLocation", "testName");
//            Job result = jobsSAO.servicePostJob(testJob);
//            Assert.assertNotEquals(result.getJobId(), 0);
//
//        @Test
//        public void selectJobNoLocation() {
//            List<Job> jobList = jobSearchDAO.selectJob("nothing", "management");
//            Assert.assertNotEquals(jobList.size(), 0);
//
//        }
//
//        @Test
//        public void selectJobNoType() {
//            List<Job> jobList = jobSearchDAO.selectJob("testLocation2", "nothing");
//            Assert.assertNotEquals(jobList.size(), 0);
//
//        }
//
//        @Test
//        public void selectJobNoLocationNoType() {
//            List<Job> jobList = jobSearchDAO.selectJob("nothing", "nothing");
//            Assert.assertNotEquals(jobList.size(), 0);
//
//        }
//
//
//    }





//Example from Dylan's CompanyJobs'

//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//    public class CompanyJobsSALTests {
//        CompanyJobsDALImp jobsDAO = new CompanyJobsDALImp();
//        CompanyJobsSALImp jobsSAO = new CompanyJobsSALImp(jobsDAO);
//
//        @Test
//        public void servicePostJobSuccess(){
//            Job testJob = new Job(8, "testTitle", "management", "testDescription", -1, "testLocation", "testName");
//            Job result = jobsSAO.servicePostJob(testJob);
//            Assert.assertNotEquals(result.getJobId(), 0);
//        };
//
//        @Test(expectedExceptions = EmptyInput.class, expectedExceptionsMessageRegExp = "All input must be filled out!")
//        public void servicePostJobEmptyInput(){
//            Job testJob = new Job(1, "", "", "",-1, "", "");
//            jobsSAO.servicePostJob(testJob);
//            Assert.fail();
//        }
//
//        @Test
//        public void serviceViewPostedJobsSuccess(){
//            List<Job> testJobList = jobsSAO.serviceViewJobs(0);
//            Assert.assertTrue(testJobList.size() >= 1);
//        };
//
//        // will not return error message, instead list returns null or empty. high priority bug, low severity.
//        @Test(expectedExceptions = NoJobFound.class, expectedExceptionsMessageRegExp = "There are no posted jobs with the company ID provided!")
//        public void serviceViewPostedJobsNoPostedJobs(){
//            jobsSAO.serviceViewJobs(-1000000000);
//            Assert.fail();
//        };
//
//
//        @Test
//        public void serviceDeleteJobsSuccess(){
//            int result = jobsSAO.serviceDeleteJobs(6);
//            Assert.assertTrue(result != 0);
//        };
//
//        @Test(expectedExceptions = NoJobFound.class, expectedExceptionsMessageRegExp = "There are no posted jobs with the company ID provided!")
//        public void serviceDeleteJobsNoJobToDelete(){
//            jobsSAO.serviceDeleteJobs(-500);
//        };
//
//    }


















}
