package com.watercooler.saos;

import com.watercooler.entities.SkillTest;
import com.watercooler.daos.CreateTestDAOImp;
import com.watercooler.utilities.customExceptions.InputTooLong;
import com.watercooler.utilities.customExceptions.DatabaseError;
import com.watercooler.utilities.customExceptions.EmptyField;

public class CreateTestSAOImp implements CreateTestSAOInt {
    private CreateTestDAOImp daoImp;

    public CreateTestSAOImp(CreateTestDAOImp daoImp) {
        this.daoImp = daoImp;
    }

    public CreateTestDAOImp getDaoImp() {
        return daoImp;
    }

    public void setDaoImp(CreateTestDAOImp daoImp) {
        this.daoImp = daoImp;
    }

    @Override
    public boolean createSkillTestService(SkillTest test) {
        if (test.getQuestionOne().length() == 0 ||
            test.getAnswerOne().length() == 0 ||
            test.getQuestionTwo().length() == 0 ||
            test.getAnswerTwo().length() == 0 ||
            test.getQuestionThree().length() == 0 ||
            test.getAnswerThree().length() == 0) {
            throw new EmptyField("All fields must be filled.");
        }

        if (test.getQuestionOne().length() > 100) {
            throw new InputTooLong("Inputted first question is too long.");
        } else if (test.getAnswerOne().length() > 100) {
            throw new InputTooLong("Inputted first answer is too long.");
        } else if (test.getQuestionTwo().length() > 100) {
            throw new InputTooLong("Inputted second question is too long.");
        } else if (test.getAnswerTwo().length() > 100) {
            throw new InputTooLong("Inputted second answer is too long.");
        } else if (test.getQuestionThree().length() > 100) {
            throw new InputTooLong("Inputted third question is too long.");
        } else if (test.getAnswerThree().length() > 100) {
            throw new InputTooLong("Inputted third answer is too long.");
        }

        int rowcount = daoImp.createSkillTestData(test);
        if (rowcount == 1) {
            return true;
        } else {
            throw new DatabaseError("Test addition unsuccessful. Please contact administration.");
        }
    }
}
