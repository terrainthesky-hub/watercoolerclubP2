package com.watercooler.daos;

import com.watercooler.entities.Applicant;
import com.watercooler.entities.Job;

import java.util.List;

public interface CompanyJobsDAL {
    Job postJob(Job job);

    List<Job> viewJobs(int companyId);

    List<Applicant> viewApplicants(int jobId);

    int deleteJobs(int jobId);
}
