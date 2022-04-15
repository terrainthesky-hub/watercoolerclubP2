package com.watercooler.serviceLayerTests;

import com.watercooler.entities.SkillTest;
import com.watercooler.daos.SkillTestDAOImp;
import com.watercooler.saos.SkillTestSAOImp;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.Assert;

public class SkillTestSERLTests{
    SkillTestDAOImp skillTestDAO = new SkillTestDAOImp();
    SkillTestSAOImp skillTestSAO = new SkillTestSAOImp(skillTestDAO);

    @Test
    public void getAllTestsServiceSuccess() {
        // needs to be stubbed
    }

    @Test
    public void noTestsReturned() {

    }

    @Test
    public void getSpecificTestServiceSuccess() {
        // needs to be stubbed
    }

    @Test
    public void placeApplicantServiceSuccess() {
        // needs to be stubbed
    }
}
