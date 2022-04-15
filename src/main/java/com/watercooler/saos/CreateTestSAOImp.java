package com.watercooler.saos;

import com.watercooler.entities.SkillTest;
import com.watercooler.daos.CreateTestDAOImp;
import com.watercooler.utilities.customExceptions.InputTooLong;

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
        daoImp.createSkillTestData(test);
        return false;
    }
}
