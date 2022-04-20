package com.watercooler.apis;


import com.google.gson.Gson;
import com.watercooler.daos.CompanyJobsDALImp;
import com.watercooler.entities.Applicant;
import com.watercooler.entities.Job;
import com.watercooler.saos.CompanyJobsSALImp;
import io.javalin.http.Handler;

import java.util.List;

public class ManagingJobsController {
    CompanyJobsDALImp DAO = new CompanyJobsDALImp();
    CompanyJobsSALImp SAO = new CompanyJobsSALImp(DAO);

    public Handler createJobPost = ctx -> {
        String requestBody = ctx.body();
        Gson gson = new Gson();
        Job job = gson.fromJson(requestBody, Job.class);
        SAO.servicePostJob(job);
        ctx.result("Job post was successfully created!");
        ctx.status(200);
    };

    public Handler viewJobs = ctx -> {
        String requestBody = ctx.body();
        Gson gson = new Gson();
        int companyId = gson.fromJson(requestBody, Integer.class);
        List<Job> jobs = SAO.serviceViewJobs(companyId);
        for (Job job: jobs){
            if(job.getCompanyId() == companyId){
                String jobJSON = gson.toJson(job);
                ctx.result(jobJSON);
                ctx.status(200);
            }
        }
    };

    public Handler viewApplicants = ctx -> {
        String requestBody = ctx.body();
        Gson gson = new Gson();
        int jobId = gson.fromJson(requestBody, Integer.class);
        List<Applicant> applicants = SAO.serviceViewApplicants(jobId);
        for (Applicant applicant: applicants){
            String applicantJSON = gson.toJson(applicant);
            ctx.result(applicantJSON);
            ctx.status(200);
        }
    };

    public Handler deleteJobPost = ctx -> {
        String requestBody = ctx.body();
        Gson gson = new Gson();
        int jobId = gson.fromJson(requestBody, Integer.class);
        SAO.serviceDeleteJobs(jobId);
        ctx.result("Job post successfully removed.");
        ctx.status(200);
    };
}
