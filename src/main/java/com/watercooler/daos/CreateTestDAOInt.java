package com.watercooler.daos;

import com.watercooler.entities.SkillTest;

public interface CreateTestDAOInt {
    //This will give the test information to the database to input.
    int createSkillTestData(SkillTest test);

}
