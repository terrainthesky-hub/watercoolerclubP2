package com.watercooler.saos;

import com.watercooler.entities.Applicant;
import com.watercooler.entities.Job;

import java.util.List;

public class CompanyJobsSALImp implements CompanyJobsSAL{

    @Override
    public Job servicePostJob(Job job) {
        return null;
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
