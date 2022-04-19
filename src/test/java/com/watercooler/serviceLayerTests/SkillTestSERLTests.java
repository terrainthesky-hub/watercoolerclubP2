package com.watercooler.serviceLayerTests;

import com.watercooler.entities.SkillTest;
import com.watercooler.daos.SkillTestDAOImp;
import com.watercooler.saos.SkillTestSAOImp;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SkillTestSERLTests{
    public static SkillTestDAOImp skillTestDAO;
    public static SkillTestSAOImp skillTestSAO;
    public static List<SkillTest> mockList = new ArrayList<SkillTest>();
    public static SkillTest mockTest = new SkillTest(-1, "test", "test", "test", "test", "test", "test", -1);


    @BeforeClass
    public void setup() {
        skillTestDAO = Mockito.mock(SkillTestDAOImp.class);
        skillTestSAO = new SkillTestSAOImp(skillTestDAO);
        mockList.add(mockTest);
    }

    @Test
    public void getAllTestsServiceSuccess() {
        Mockito.doReturn(mockList).when(skillTestDAO).getAllSkillTests();
        HashMap<Integer, String> resultMap = skillTestSAO.getAllSkillTests();
        Assert.assertEquals(resultMap.get(-1), "test");
    }

    @Test
    public void getSpecificTestServiceSuccess() {
        Mockito.doReturn(mockTest).when(skillTestDAO).getSpecificSkillTest(-1);
        SkillTest test = skillTestSAO.getSpecificSkillTest(-1);
        Assert.assertEquals(test, mockTest);
    }

    @Test
    public void placeApplicantServiceSuccess() {
        Mockito.doReturn(1).when(skillTestDAO).placePassingApplicant(-1, -1);
        boolean result = skillTestSAO.placePassingApplicant(-1, -1);
        Assert.assertTrue(result);

    }

    @Test
    public void placeApplicantOnce() {
        Mockito.doReturn(1).when(skillTestDAO).placePassingApplicant(-1, -1);
        skillTestSAO.placePassingApplicant(-1, -1);
        Mockito.verify(skillTestDAO, VerificationModeFactory.times(1)).placePassingApplicant(-1, -1);
    }
}
