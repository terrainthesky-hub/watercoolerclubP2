package com.watercooler.serviceLayerTests;

import com.watercooler.daos.UsernamePasswordCompanyDAOInterface;
import com.watercooler.entities.UsernamePasswordApplicant;
import com.watercooler.entities.UsernamePasswordCompany;
import com.watercooler.saos.UsernamePasswordApplicantSAOImp;
import com.watercooler.saos.UsernamePasswordApplicantSAOInterface;
import com.watercooler.saos.UsernamePasswordCompanySAOImp;
import com.watercooler.saos.UsernamePasswordCompanySAOInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUsernamePasswordCreateAndCheck {

    UsernamePasswordApplicantSAOInterface usernamePasswordApplicationSAO = new UsernamePasswordApplicantSAOImp();

    @Test
    public void createApplicantSuccess() {
        UsernamePasswordApplicant newApplicant = new UsernamePasswordApplicant(1, "Coloniel", "Popeyes");
        UsernamePasswordApplicant resultingApplicant = usernamePasswordApplicationSAO.createAccountApplicant(newApplicant);
        Assert.assertNotEquals(resultingApplicant.getApplicantId(), 0);

    }

    UsernamePasswordCompanySAOInterface usernamePasswordCompanySAO = new UsernamePasswordCompanySAOImp();


    @Test
    public void createCompanyPersonSuccess() {
        UsernamePasswordCompany newCompanyPerson = new UsernamePasswordCompany(5, "Soysauce", "Ambrosia");
        UsernamePasswordCompany resultingCompanyPerson = usernamePasswordCompanySAO.createAccountCompany(newCompanyPerson);
        Assert.assertNotEquals(resultingCompanyPerson.getCompanyId(), 0);
    }

    @Test
    public void selectApplicantByIdSuccess() {
        UsernamePasswordApplicant usernamePasswordApplicant = usernamePasswordApplicationSAO.selectApplicantById(1);
        Assert.assertEquals(usernamePasswordApplicant.getApplicantId(), 1);
    }
    @Test
    public void selectCompanyByIdSuccess() {
        UsernamePasswordCompany usernamePasswordCompany = usernamePasswordCompanySAO.selectCompanyAccountById(1);
        Assert.assertEquals(usernamePasswordCompany.getCompanyId(), 1);
    }

}