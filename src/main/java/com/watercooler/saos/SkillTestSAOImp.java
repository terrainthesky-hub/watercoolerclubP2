package com.watercooler.saos;

import com.watercooler.entities.SkillTest;
import com.watercooler.daos.SkillTestDAOImp;
import com.watercooler.utilities.customExceptions.DatabaseError;

import java.util.HashMap;
import java.util.List;

public class SkillTestSAOImp implements SkillTestSAOInt {
    private SkillTestDAOImp daoImp;

    public SkillTestSAOImp(SkillTestDAOImp daoImp) {
        this.daoImp = daoImp;
    }

    @Override
    public HashMap<Integer, String> getAllSkillTests() {
        List<SkillTest> resultList = daoImp.getAllSkillTests();
        HashMap<Integer, String> resultMap = new HashMap<Integer, String>();
        for (int i = 0; i < resultList.size(); i++) {
            SkillTest currentTest = resultList.get(i);
            resultMap.put(currentTest.getTestId(), currentTest.getQuestionOne());
        }

        return resultMap;
    }

    @Override
    public SkillTest getSpecificSkillTest(int testId) {
        SkillTest test = daoImp.getSpecificSkillTest(testId);
        return test;
    }

    @Override
    public boolean placePassingApplicant(int testId, int individualId) {
        int result = daoImp.placePassingApplicant(testId, individualId);
        if (result == 1) {
            return true;
        } else {
            throw new DatabaseError("Record creation unsuccessful. Please contact administration.");
        }
    }

    public SkillTestDAOImp getDaoImp() {
        return daoImp;
    }

    public void setDaoImp(SkillTestDAOImp daoImp) {
        this.daoImp = daoImp;
    }
}
