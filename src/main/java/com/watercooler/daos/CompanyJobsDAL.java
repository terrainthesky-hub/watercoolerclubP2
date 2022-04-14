package com.watercooler.daos;

import com.watercooler.entities.Job;

public interface CompanyJobsDAL {
    Job postJob();

    Job viewJobs();

    Job viewApplicants();

    Job deleteJobs();
}
