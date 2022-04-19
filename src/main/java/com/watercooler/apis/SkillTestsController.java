package com.watercooler.apis;

import com.google.gson.Gson;
import io.javalin.http.Handler;

import com.watercooler.daos.SkillTestDAOImp;
import com.watercooler.daos.CreateTestDAOImp;
import com.watercooler.saos.SkillTestSAOImp;
import com.watercooler.saos.CreateTestSAOImp;
import com.watercooler.entities.SkillTest;

import com.watercooler.utilities.customExceptions.*;

import java.util.HashMap;

public class SkillTestsController {
    SkillTestDAOImp skillTestDAO = new SkillTestDAOImp();
    SkillTestSAOImp skillTestSAO = new SkillTestSAOImp(skillTestDAO);

    CreateTestDAOImp createTestDAO = new CreateTestDAOImp();
    CreateTestSAOImp createTestSAO = new CreateTestSAOImp(createTestDAO);

    public Handler getSkillTests = ctx -> {
        HashMap<Integer, String> map = skillTestSAO.getAllSkillTests();
        Gson gson = new Gson();
        String jsonString = gson.toJson(map);
        ctx.result(jsonString);
        ctx.status(200);
    };

    public Handler getSingleSkillTest = ctx -> {
        int testId = Integer.parseInt(ctx.pathParam("skillTestId"));
        SkillTest skillTest = skillTestSAO.getSpecificSkillTest(testId);
        Gson gson = new Gson();
        String jsonString = gson.toJson(skillTest);
        ctx.result(jsonString);
        ctx.status(200);
    };

    public Handler postTestResult = ctx -> {
      int testId = Integer.parseInt(ctx.pathParam("skillTestId"));
      int applicantId = Integer.parseInt(ctx.pathParam("applicantId"));
      try {
          skillTestSAO.placePassingApplicant(testId, applicantId);
          ctx.result("You passed the test!");
          ctx.status(201);
      } catch (DatabaseError exception) {
          ctx.result(exception.getMessage());
          ctx.status(500);
      }
    };

    public Handler postNewSkillTest = ctx -> {
      String body = ctx.body();
      Gson gson = new Gson();
      try {
          SkillTest skillTest = gson.fromJson(body, SkillTest.class);
          createTestSAO.createSkillTestService(skillTest);
          ctx.result("Test created successfully.");
          ctx.status(201);
      } catch (EmptyField | InputTooLong exception) {
          ctx.result(exception.getMessage());
          ctx.status(400);
      } catch (DatabaseError exception) {
          ctx.result(exception.getMessage());
          ctx.status(500);
      }
    };
}
