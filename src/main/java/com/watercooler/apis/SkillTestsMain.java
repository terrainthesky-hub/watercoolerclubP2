package com.watercooler.apis;

import io.javalin.Javalin;
import com.watercooler.apis.SkillTestsController;

public class SkillTestsMain {

    public static void main(String[] args) {
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

    } //main end

}
