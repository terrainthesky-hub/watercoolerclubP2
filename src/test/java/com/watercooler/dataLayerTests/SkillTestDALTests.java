package com.watercooler.dataLayerTests;

import com.watercooler.daos.SkillTestDAOImp;
import com.watercooler.entities.SkillTest;
import java.util.List;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SkillTestDALTests {
    SkillTestDAOImp skillTestDataImp = new SkillTestDAOImp();

    @Test
    public void getAllTestsSuccess() {
        List<SkillTest> resultList = skillTestDataImp.getAllSkillTests();
        Assert.assertNotEquals(resultList.size(), 0);
    }

    @Test
    public void getSpecificTestSuccess() {
        SkillTest resultTest = skillTestDataImp.getSpecificSkillTests(-1);
        String resultTestQuestionOne = resultTest.getQuestionOne();
        Assert.assertEquals(resultTestQuestionOne, "test");
    }

    @Test
    public void placePassingSuccess() {
        int resultCount = skillTestDataImp.placePassingApplicant(-1, -1);
        Assert.assertEquals(resultCount, 1);
    }

}
