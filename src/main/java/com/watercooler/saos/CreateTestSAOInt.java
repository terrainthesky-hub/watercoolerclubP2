package com.watercooler.saos;

import com.watercooler.entities.SkillTest;
import com.watercooler.utilities.customExceptions.InputTooLong;

public interface CreateTestSAOInt{
    //this will dissect the skill test information given before handing it to the database if it's okay
    boolean createSkillTestService(SkillTest test);

}
