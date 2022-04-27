package com.watercooler.apis;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.watercooler.daos.SkillTestDAOInt;
import com.watercooler.daos.SkillTestDAOImp;
import com.watercooler.daos.CreateTestDAOInt;
import com.watercooler.daos.CreateTestDAOImp;
import com.watercooler.saos.SkillTestSAOInt;
import com.watercooler.saos.SkillTestSAOImp;
import com.watercooler.saos.CreateTestSAOInt;
import com.watercooler.saos.CreateTestSAOImp;
import com.watercooler.entities.SkillTest;

import com.watercooler.utilities.customExceptions.*;

import java.util.HashMap;

public class SkillTestsController {
    SkillTestDAOInt skillTestDAO = new SkillTestDAOImp();
    SkillTestSAOInt skillTestSAO = new SkillTestSAOImp(skillTestDAO);

    CreateTestDAOInt createTestDAO = new CreateTestDAOImp();
    CreateTestSAOInt createTestSAO = new CreateTestSAOImp(createTestDAO);

    public static Logger logger = LogManager.getLogger(SkillTestsController.class);

    public Handler getSkillTests = ctx -> {
        logger.info("BEGIN API Handler getSkillTests with information:\n" + ctx);
        HashMap<Integer, String> map = skillTestSAO.getAllSkillTests();
        Gson gson = new Gson();
        String jsonString = gson.toJson(map);
        ctx.result(jsonString);
        ctx.status(200);
        logger.info("FINISH API Handler getSkillTests with result:\n" + jsonString + "\nStatus Code: " + 200);
    };

    public Handler getSingleSkillTest = ctx -> {
        logger.info("BEGIN API Handler getSingleSkillTest with information:\n" + ctx);
        int testId = Integer.parseInt(ctx.pathParam("skillTestId"));
        SkillTest skillTest = skillTestSAO.getSpecificSkillTest(testId);
        Gson gson = new Gson();
        String jsonString = gson.toJson(skillTest);
        ctx.result(jsonString);
        ctx.status(200);
        logger.info("FINISH API Handler getSingleSkillTest with result:\n" + jsonString + "\nStatus Code: " + 200);
    };

    public Handler postTestResult = ctx -> {
        logger.info("BEGIN API Handler postTestResult with information:\n" + ctx);
        int testId = Integer.parseInt(ctx.pathParam("skillTestId"));
        int applicantId = Integer.parseInt(ctx.pathParam("applicantId"));
        try {
            skillTestSAO.placePassingApplicant(testId, applicantId);
            ctx.result("{\"message\": \"You passed the test!\"}");
            ctx.status(201);
            logger.info("FINISH API Handler postTestResult with result:\nYou passed the test!\nStatus Code: " + 201);
        } catch (DatabaseError exception) {
            ctx.result("{\"errorMessage\": \""+ exception.getMessage() +"\"}");
            ctx.status(500);
            logger.error("ERROR with API Handler postTestResult with error: " + exception.getMessage());
        }
    };

    public Handler postNewSkillTest = ctx -> {
        logger.info("BEGIN API Handler postNewSkillTest with information:\n" + ctx);
        String body = ctx.body();
        Gson gson = new Gson();
        try {
            SkillTest skillTest = gson.fromJson(body, SkillTest.class);
            createTestSAO.createSkillTestService(skillTest);
            ctx.result("{\"message\": \"Test created successfully!\"}");
            ctx.status(201);
            logger.info("FINISH API Handler postNewSkillTest with result:\nTest created successfully.\nStatus Code: " + 201);
        } catch (EmptyField | InputTooLong exception) {
            ctx.result("{\"errorMessage\": \""+ exception.getMessage() +"\"}");
            ctx.status(400);
            logger.warn("USER ERROR with API Handler postNewSkillTest with error: " + exception.getMessage());
        } catch (DatabaseError exception) {
            ctx.result("{\"errorMessage\": \""+ exception.getMessage() +"\"}");
            ctx.status(500);
            logger.error("ERROR with API Handler postNewSkillTest with error: " + exception.getMessage());
        }
    };
}
