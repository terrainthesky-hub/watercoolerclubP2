package com.watercooler.javalin;
import com.google.gson.Gson;
import com.watercooler.daos.ApplicantDAO;
import com.watercooler.daos.CompanyDAO;
import com.watercooler.daos.CompanyDAOImp;
import com.watercooler.entities.Applicant;
import com.watercooler.entities.Company;
import com.watercooler.saos.ApplicantSAOImp;
import com.watercooler.saos.ApplicantSAOSInterface;
import com.watercooler.saos.CompanySAOImp;
import com.watercooler.saos.CompanySAOSInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.javalin.http.Handler;
import com.watercooler.daos.ApplicantDAOImp;



public class UpdateApplicantController{

    public static Logger logger = LogManager.getLogger(UpdateApplicantController.class);
    ApplicantDAO DAO = new ApplicantDAOImp();
    ApplicantSAOSInterface SAOS = new ApplicantSAOImp(DAO);


    public Handler updateApplicant = ctx -> {
        logger.info("update an applicant");
        String body = ctx.body();
        Gson gson = new Gson();
        Applicant updateApplicant= gson.fromJson(body,Applicant.class);
        String infoUpdate = gson.toJson(updateApplicant);
        int info = SAOS.catchErrorsApplicant(updateApplicant);
        ctx.result(String.valueOf(infoUpdate));
        logger.info("updated applicant");


     };

    CompanyDAO SI = new CompanyDAOImp();
    CompanySAOSInterface LI  = new CompanySAOImp(SI);

    public Handler updateCompany = ctx -> {
        logger.info("update company");
        String body = ctx.body();
        Gson gson = new Gson();
        Company updateCompany = gson.fromJson(body,Company.class);
        String infoupdate = gson.toJson(updateCompany);
        int info = LI.catchErrorsCompany(updateCompany);
        ctx.result(String.valueOf(infoupdate));
        logger.info("updated company");


     };


}
