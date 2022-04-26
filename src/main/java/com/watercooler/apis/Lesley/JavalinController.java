package com.watercooler.apis.Lesley;

import com.google.gson.Gson;
import com.watercooler.entities.Lesley.UsernamePasswordApplicant;
import com.watercooler.entities.Lesley.UsernamePasswordCompany;
import com.watercooler.saos.Lesley.UsernamePasswordApplicantSAOInterface;
import com.watercooler.saos.Lesley.UsernamePasswordCompanySAOInterface;
import com.watercooler.utilities.customExceptions.Lesley.CustomUncheckedException;
import io.javalin.http.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JavalinController {



    public static Logger logger = LogManager.getLogger(JavalinController.class);

    public UsernamePasswordApplicantSAOInterface usernamePasswordApplicantSAOImp;
    public UsernamePasswordCompanySAOInterface usernamePasswordCompanySAOImp;

    public JavalinController(UsernamePasswordApplicantSAOInterface usernamePasswordApplicantSAOImp, UsernamePasswordCompanySAOInterface usernamePasswordCompanySAOImp) {
        this.usernamePasswordApplicantSAOImp = usernamePasswordApplicantSAOImp;
        this.usernamePasswordCompanySAOImp = usernamePasswordCompanySAOImp;
    }

    public Handler UnPwApplicantVerify = ctx -> {
        try{
            logger.info("getting an applicant");

        String body = ctx.body();

        Gson gson = new Gson();
        UsernamePasswordApplicant usernamePasswordApplicantGson = gson.fromJson(body, UsernamePasswordApplicant.class);

        int info = usernamePasswordApplicantSAOImp.catchErrorsUnPwApplicant(usernamePasswordApplicantGson);
//

        ctx.result(String.valueOf(info));
        logger.info("applicant got");
    } catch (CustomUncheckedException e){
            logger.warn("Too few or too many characters");
            ctx.result(e.getMessage());
            ctx.status(405);
        }
    };

    public Handler UnPwCompanyVerify = ctx -> {
        try {
            logger.info("getting an company");
            String body = ctx.body();

            Gson gson = new Gson();
            UsernamePasswordCompany usernamePasswordCompanyGson = gson.fromJson(body, UsernamePasswordCompany.class);

            int info = usernamePasswordCompanySAOImp.catchErrorsUnPwCompany(usernamePasswordCompanyGson);
//
//        String infoConvert = gson.toJson(info);

            ctx.result(String.valueOf(info));
            logger.info("company got");
        } catch (CustomUncheckedException e){
            logger.warn("Too few or too many characters");
            ctx.result(e.getMessage());
            ctx.status(405);
        }
    };




    public Handler UnPwApplicantCreate = ctx -> {
        // body
        try{
        logger.info("Creating applicant account");
        String body = ctx.body();

        Gson gson = new Gson();

        UsernamePasswordApplicant usernamePasswordApplicantGson = gson.fromJson(body, UsernamePasswordApplicant.class);

        UsernamePasswordApplicant creation = usernamePasswordApplicantSAOImp.catchErrorsAccountApplicant(usernamePasswordApplicantGson);

        String creating = gson.toJson(creation);

        ctx.result(creating);
        ctx.status(201);
        logger.info("Created applicant account");}
        catch (CustomUncheckedException e){
            logger.warn("Too few or too many characters");
            ctx.result(e.getMessage());
            ctx.status(405);
        }
        //get return value of the service layer


        // return to the requester

    };

    public Handler UnPwCompanyCreate = ctx -> {
        try {
            logger.info("Creating company account");

            String body = ctx.body();

            Gson gson = new Gson();

            UsernamePasswordCompany usernamePasswordCompanyGson = gson.fromJson(body, UsernamePasswordCompany.class);

            UsernamePasswordCompany creation = usernamePasswordCompanySAOImp.catchErrorsUsernamePasswordCompany(usernamePasswordCompanyGson);

            String creating = gson.toJson(creation);

            ctx.result(creating);
            logger.info("Created company account");
        } catch (CustomUncheckedException e){
                logger.warn("Too few or too many characters");
                ctx.result(e.getMessage());
                ctx.status(405);
        } ;
    };
}

// *** unused selecting by id to get username and password ***

//    public Handler UnPwApplicantGet = ctx -> {
//        logger.info("getting an applicant");
//        String body = ctx.body();
//
//        Gson gson = new Gson();
//        UsernamePasswordApplicant usernamePasswordApplicantGson = gson.fromJson(body, UsernamePasswordApplicant.class);
//
//        UsernamePasswordApplicant info = usernamePasswordApplicantSAOImp.selectApplicantById(usernamePasswordApplicantGson.getApplicantId());
////
//        String infoConvert = gson.toJson(info);
//
//        ctx.result(infoConvert);
//        logger.info("applicant got");
////        int id2 = id.getApplicantId();
////
////        String id3 = gson.toJson(id2);
//////        id3 = gson.toJson(id2);
////
////        ctx.result(id3);
//
//    };
//
//    public Handler UnPwCompanyGet = ctx -> {
//
//        String body = ctx.body();
//
//        Gson gson = new Gson();
//        UsernamePasswordCompany usernamePasswordCompanyGson = gson.fromJson(body, UsernamePasswordCompany.class);
//
//        UsernamePasswordCompany info = usernamePasswordCompanySAOImp.selectCompanyById(usernamePasswordCompanyGson.getCompanyId());
////
//        String infoConvert = gson.toJson(info);
//
//        ctx.result(infoConvert);
//        int id2 = id.getApplicantId();
//
//        String id3 = gson.toJson(id2);
////        id3 = gson.toJson(id2);
//
//        ctx.result(id3);

//    };

