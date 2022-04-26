package com.watercooler.javalin;
import com.watercooler.saos.ApplicantSAOImp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.watercooler.daos.ApplicantDAOImp;



public class UpdateApplicantController{

    public static Logger logger = LogManager.getLogger(UpdateApplicantController.class);
    public ApplicantSAOImp SAOS;
    Public UpdateApplicantController(ApplicantSAOImp SAOS) {
        this.SAOS = SAOS;



    }

}



