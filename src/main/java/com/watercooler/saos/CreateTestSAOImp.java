package com.watercooler.saos;

import com.watercooler.entities.SkillTest;
import com.watercooler.daos.CreateTestDAOInt;
import com.watercooler.utilities.customExceptions.InputTooLong;
import com.watercooler.utilities.customExceptions.DatabaseError;
import com.watercooler.utilities.customExceptions.EmptyField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateTestSAOImp implements CreateTestSAOInt {
    CreateTestDAOInt daoImp;
    public static Logger logger = LogManager.getLogger(CreateTestSAOImp.class);

    public CreateTestSAOImp(CreateTestDAOInt daoImp) {
        this.daoImp = daoImp;
    }

    @Override
    public boolean createSkillTestService(SkillTest test) {
        logger.info("BEGIN SERL function createSkillTestService with information:\n" + test);
        if (test.getQuestionOne().length() == 0 ||
            test.getAnswerOne().length() == 0 ||
            test.getQuestionTwo().length() == 0 ||
            test.getAnswerTwo().length() == 0 ||
            test.getQuestionThree().length() == 0 ||
            test.getAnswerThree().length() == 0) {
            logger.warn("Throwing EmptyField error.");
            throw new EmptyField("All fields must be filled.");
        }

        if (test.getQuestionOne().length() > 100) {
            logger.warn("Throwing InputTooLong error.");
            throw new InputTooLong("Inputted first question is too long.");
        } else if (test.getAnswerOne().length() > 100) {
            logger.warn("Throwing InputTooLong error.");
            throw new InputTooLong("Inputted first answer is too long.");
        } else if (test.getQuestionTwo().length() > 100) {
            logger.warn("Throwing InputTooLong error.");
            throw new InputTooLong("Inputted second question is too long.");
        } else if (test.getAnswerTwo().length() > 100) {
            logger.warn("Throwing InputTooLong error.");
            throw new InputTooLong("Inputted second answer is too long.");
        } else if (test.getQuestionThree().length() > 100) {
            logger.warn("Throwing InputTooLong error.");
            throw new InputTooLong("Inputted third question is too long.");
        } else if (test.getAnswerThree().length() > 100) {
            logger.warn("Throwing InputTooLong error.");
            throw new InputTooLong("Inputted third answer is too long.");
        }

        int rowcount = daoImp.createSkillTestData(test);
        if (rowcount == 1) {
            logger.info("FINISH SERL function createSkillTestService with result:\n" + rowcount);
            return true;
        } else {
            logger.error("Throwing DatabaseError.");
            throw new DatabaseError("Test addition unsuccessful. Please contact administration.");
        }
    }
}
