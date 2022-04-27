package com.watercooler.saos;

import com.watercooler.entities.SkillTest;
import com.watercooler.daos.SkillTestDAOInt;
import com.watercooler.utilities.customExceptions.DatabaseError;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SkillTestSAOImp implements SkillTestSAOInt {
    SkillTestDAOInt daoImp;
    public static Logger logger = LogManager.getLogger(SkillTestSAOImp.class);

    public SkillTestSAOImp(SkillTestDAOInt daoImp) {
        this.daoImp = daoImp;
    }

    @Override
    public HashMap<Integer, String> getAllSkillTests() {
        logger.info("BEGIN SERL function getAllSkillTests.");
        List<SkillTest> resultList = daoImp.getAllSkillTests();
        HashMap<Integer, String> resultMap = new HashMap<Integer, String>();
        for (int i = 0; i < resultList.size(); i++) {
            SkillTest currentTest = resultList.get(i);
            resultMap.put(currentTest.getTestId(), currentTest.getQuestionOne());
        }
        logger.info("FINISH SERL function getAllSkillTests with result:\n" + resultMap);
        return resultMap;
    }

    @Override
    public SkillTest getSpecificSkillTest(int testId) {
        logger.info("BEGIN SERL function getSpecificSkillTest with information:\n" + testId);
        SkillTest test = daoImp.getSpecificSkillTest(testId);
        logger.info("FNISH SERL function getSpecificSkillTest with result:\n" + test);
        return test;
    }

    @Override
    public boolean placePassingApplicant(int testId, int individualId) {
        logger.info("BEGIN SERL function placePassingApplicant with information:\n" + testId + "\n" + individualId);
        int result = daoImp.placePassingApplicant(testId, individualId);
        if (result == 1) {
            logger.info("FINISH SERL function placePassingApplicant with result:\ntrue");
            return true;
        } else {
            logger.warn("Throwing DatabaseError.");
            throw new DatabaseError("Record creation unsuccessful. Please contact administration.");
        }
    }
}
