package com.watercooler.saos;

import com.watercooler.entities.Applicant;
import com.watercooler.entities.Job;

import java.util.List;

public interface CompanyJobsSAL {
    Job servicePostJob(Job job);

    List<Job> serviceViewJobs(int companyId);

    List<Applicant> serviceViewApplicants(int jobId);

    int serviceDeleteJobs(int jobId);
}
