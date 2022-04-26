package com.watercooler.javalin;
import com.watercooler.daos.ApplicantDAOImp;
import com.watercooler.saos.ApplicantSAOImp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.javalin.Javalin;

public class App {

    public static Logger logger = LogManager.getLogger(App.class);


    public static void main(String[] args) {
        logger.info("update Javalin object now");
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
    });
        ApplicantDAOImp DAO = new ApplicantDAOImp();
        ApplicantSAOImp SAOS = new ApplicantSAOImp(DAO);
        UpdateApplicantController updateApplicantController = new UpdateApplicantController(SAOS);

        app.post("/update/applicant", controller.updateApplicants);

        logger.info("Starting web server");


        app.start();










}

}
