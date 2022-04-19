package com.watercooler.serviceLayerTests;

import com.watercooler.saos.CreateTestSAOImp;
import com.watercooler.daos.CreateTestDAOImp;

import com.watercooler.utilities.customExceptions.EmptyField;
import com.watercooler.utilities.customExceptions.InputTooLong;
import com.watercooler.entities.SkillTest;
import com.watercooler.entities.OversizedText;

import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

public class CreateTestSERLTests {

    public static CreateTestDAOImp createTestDAO;
    public static CreateTestSAOImp createTestSAO;
    OversizedText text = new OversizedText();
    public static SkillTest testMock = new SkillTest(-1, "test", "test", "test", "test", "test", "test", -1);

    @BeforeClass
    public void setup() {
        createTestDAO = Mockito.mock(CreateTestDAOImp.class);
        createTestSAO = new CreateTestSAOImp(createTestDAO);
    }

    @Test
    public void validateTestSuccess() {
        Mockito.doReturn(1).when(createTestDAO).createSkillTestData(testMock);
        boolean result = createTestSAO.createSkillTestService(testMock);
        Assert.assertTrue(result);
    }

    @Test
    public void checkCreateCalledOnce() {
        Mockito.doReturn(1).when(createTestDAO).createSkillTestData(testMock);
        createTestSAO.createSkillTestService(testMock);
        Mockito.verify(createTestDAO, VerificationModeFactory.times(1)).createSkillTestData(testMock);
    }

    @Test(expectedExceptions = InputTooLong.class, expectedExceptionsMessageRegExp = "Inputted first question is too long.")
    public void validateFirstQuestionFailure() {
        SkillTest skillTest = new SkillTest(-2, text.oversizedText, "test", "test", "test", "test", "test", -2);
        createTestSAO.createSkillTestService(skillTest);
    }

    @Test(expectedExceptions = InputTooLong.class, expectedExceptionsMessageRegExp = "Inputted first answer is too long.")
    public void validateFirstAnswerFailure() {
        SkillTest skillTest = new SkillTest(-2, "test", text.oversizedText, "test", "test", "test", "test", -2);
        createTestSAO.createSkillTestService(skillTest);
    }

    @Test(expectedExceptions = InputTooLong.class, expectedExceptionsMessageRegExp = "Inputted second question is too long.")
    public void validateSecondQuestionFailure() {
        SkillTest skillTest = new SkillTest(-2, "test", "test", text.oversizedText, "test", "test", "test", -2);
        createTestSAO.createSkillTestService(skillTest);
    }

    @Test(expectedExceptions = InputTooLong.class, expectedExceptionsMessageRegExp = "Inputted second answer is too long.")
    public void validateSecondAnswerFailure() {
        SkillTest skillTest = new SkillTest(-2, "test", "test", "test", text.oversizedText, "test", "test", -2);
        createTestSAO.createSkillTestService(skillTest);
    }

    @Test(expectedExceptions = InputTooLong.class, expectedExceptionsMessageRegExp = "Inputted third question is too long.")
    public void validateThirdQuestionFailure() {
        SkillTest skillTest = new SkillTest(-2, "test", "test", "test", "test", text.oversizedText, "test", -2);
        createTestSAO.createSkillTestService(skillTest);
    }

    @Test(expectedExceptions = InputTooLong.class, expectedExceptionsMessageRegExp = "Inputted third answer is too long.")
    public void validateThirdAnswerFailure() {
        SkillTest skillTest = new SkillTest(-2, "test", "test", "test", "test", "test", text.oversizedText, -2);
        createTestSAO.createSkillTestService(skillTest);
    }

    @Test(expectedExceptions = EmptyField.class, expectedExceptionsMessageRegExp = "All fields must be filled.")
    public void validateNoDataInputted() {
        SkillTest skillTest = new SkillTest(-2, "test", "test", "test", "test", "test", "", -2);
        createTestSAO.createSkillTestService(skillTest);
    }

}
