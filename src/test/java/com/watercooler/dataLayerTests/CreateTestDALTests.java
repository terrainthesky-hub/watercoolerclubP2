package com.watercooler.dataLayerTests;

import com.watercooler.daos.CreateTestDAOImp;
import com.watercooler.entities.SkillTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class CreateTestDALTests {

    CreateTestDAOImp createTestDAO = new CreateTestDAOImp();

    @Test
    public void createTestSuccess() {
        SkillTest newTest = new SkillTest(-1, "test question 1", "test answer 1", "test question 2", "test answer 2", "test question 3", "test answer three 3", -1);
        int result = createTestDAO.createSkillTestData(newTest);
        Assert.assertEquals(result, 1);
    }

}
