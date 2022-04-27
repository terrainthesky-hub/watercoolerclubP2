package com.watercooler.daos;

import com.watercooler.entities.SkillTest;

import java.util.List;

public interface SkillTestDAOInt {
    //get all skill tests
    List<SkillTest> getAllSkillTests();

    //get specific skill tests
    SkillTest getSpecificSkillTest(int testId);

    //on pass, put that they passed
    int placePassingApplicant(int testId, int individualId);
}
