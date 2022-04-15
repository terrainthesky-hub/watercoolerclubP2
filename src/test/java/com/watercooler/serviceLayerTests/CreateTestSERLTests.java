package com.watercooler.serviceLayerTests;

import com.watercooler.saos.CreateTestSAOImp;
import com.watercooler.daos.CreateTestDAOImp;

import com.watercooler.utilities.customExceptions.InputTooLong;
import com.watercooler.entities.SkillTest;
import com.watercooler.entities.OversizedText;

import org.testng.annotations.Test;
import org.testng.Assert;

public class CreateTestSERLTests {

    CreateTestDAOImp createTestDAO = new CreateTestDAOImp();
    CreateTestSAOImp createTestSAO = new CreateTestSAOImp(createTestDAO);

    OversizedText text = new OversizedText();

    @Test
    public void validateTestSuccess() {
        //will not be fully tested until stubbing is learned
    }

    @Test
    public void validateFirstQuestionFailure() {
        SkillTest skillTest = new SkillTest(-2, text.oversizedText, "test", "test", "test", "test", "test", -2);
        try {
            createTestSAO.createSkillTestService(skillTest);
            Assert.fail();
        } catch (InputTooLong exception) {
            Assert.assertEquals(exception, "Inputted first question is too long.");
        }
    }

    @Test
    public void validateFirstAnswerFailure() {
        SkillTest skillTest = new SkillTest(-2, "test", text.oversizedText, "test", "test", "test", "test", -2);
        try {
            createTestSAO.createSkillTestService(skillTest);
            Assert.fail();
        } catch (InputTooLong exception) {
            Assert.assertEquals(exception, "Inputted first answer is too long.");
        }
    }

    @Test
    public void validateSecondQuestionFailure() {
        SkillTest skillTest = new SkillTest(-2, "test", "test", text.oversizedText, "test", "test", "test", -2);
        try {
            createTestSAO.createSkillTestService(skillTest);
            Assert.fail();
        } catch (InputTooLong exception) {
            Assert.assertEquals(exception, "Inputted second question is too long.");
        }
    }

    @Test
    public void validateSecondAnswerFailure() {
        SkillTest skillTest = new SkillTest(-2, "test", "test", "test", text.oversizedText, "test", "test", -2);
        try {
            createTestSAO.createSkillTestService(skillTest);
            Assert.fail();
        } catch (InputTooLong exception) {
            Assert.assertEquals(exception, "Inputted second answer is too long.");
        }
    }

    @Test
    public void validateThirdQuestionFailure() {
        SkillTest skillTest = new SkillTest(-2, "test", "test", "test", "test", text.oversizedText, "test", -2);
        try {
            createTestSAO.createSkillTestService(skillTest);
            Assert.fail();
        } catch (InputTooLong exception) {
            Assert.assertEquals(exception, "Inputted third question is too long.");
        }
    }

    @Test
    public void validateThirdAnswerFailure() {
        SkillTest skillTest = new SkillTest(-2, "test", "test", "test", "test", "test", text.oversizedText, -2);
        try {
            createTestSAO.createSkillTestService(skillTest);
            Assert.fail();
        } catch (InputTooLong exception) {
            Assert.assertEquals(exception, "Inputted third answer is too long.");
        }
    }

}
