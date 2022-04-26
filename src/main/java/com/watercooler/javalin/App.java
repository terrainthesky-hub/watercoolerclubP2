package com.watercooler.javalin;
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

        UpdateApplicantController controller = new UpdateApplicantController();

            app.post("/update/applicant", controller.updateApplicant);

            app.post("/update/Company", controller.updateCompany);


            logger.info("Starting web server");

            app.start();














}

}
