package com.watercooler.saos;

import com.watercooler.entities.SkillTest;

import java.util.HashMap;

public interface SkillTestSAOInt {

    HashMap<Integer, String> getAllSkillTests();

    SkillTest getSpecificSkillTest(int testId);

    boolean placePassingApplicant(int testId, int individualId);

}
