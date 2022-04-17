package com.watercooler.saos;

import com.watercooler.daos.CompanyJobsDALImp;
import com.watercooler.entities.Applicant;
import com.watercooler.entities.Job;
import com.watercooler.utilities.customExceptions.EmptyInput;
import com.watercooler.utilities.customExceptions.InputTooLong;

import java.util.List;

public class CompanyJobsSALImp implements CompanyJobsSAL{
    private CompanyJobsDALImp jobsDAO;

    public CompanyJobsSALImp(CompanyJobsDALImp jobsDAO) {
        this.jobsDAO = jobsDAO;
    }

    @Override
    public Job servicePostJob(Job job) {
        if(job.getTitle().length() == 0 || job.getType().length() == 0 || job.getDescription().length() == 0 || job.getLocation().length() == 0 || job.getCompanyName().length() == 0){
            throw new EmptyInput("All input must be filled out!");
        }
        if(job.getTitle().length() > 25){
            throw new InputTooLong("Job title is too long!");
        } else if(job.getType().length() > 30){
            throw new InputTooLong("Job type is too long!");
        } else if(job.getDescription().length() > 500){
            throw new InputTooLong("Job description is too long!");
        } else if(job.getLocation().length() > 100){
            throw new InputTooLong("Job location is too long!");
        } else if(job.getCompanyName().length() > 50){
            throw new InputTooLong("Company name is too long!");
        } else{
            return jobsDAO.postJob(job);
        }

    }

    @Override
    public List<Job> serviceViewJobs(int companyId) {
        return null;
    }

    @Override
    public List<Applicant> serviceViewApplicants(int jobId) {
        return null;
    }

    @Override
    public int serviceDeleteJobs(int jobId) {
        return 0;
    }
}
