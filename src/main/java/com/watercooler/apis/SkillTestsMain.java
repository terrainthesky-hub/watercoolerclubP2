package com.watercooler.apis;

import io.javalin.Javalin;
import com.watercooler.apis.SkillTestsController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SkillTestsMain {

    public static Logger logger = LogManager.getLogger(SkillTestsController.class);

    public static void main(String[] args) {
        logger.info("Application starting...");
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
                }
        );

        SkillTestsController controller = new SkillTestsController();

        app.get("/skilltest", controller.getSkillTests);
        app.get("/skilltest/{skillTestId}", controller.getSingleSkillTest);
        app.post("/skilltest/{skillTestId}/result/{applicantId}", controller.postTestResult);
        app.post("/skilltest/new", controller.postNewSkillTest);

        app.start();
        logger.info("Application started successfully.");

    } //main end

}
