package com.watercooler.dataLayerTests;


import com.watercooler.daos.UsernamePasswordApplicantDAOImp;
import com.watercooler.daos.UsernamePasswordApplicantDAOInterface;
import com.watercooler.daos.UsernamePasswordCompanyDAOImp;
import com.watercooler.daos.UsernamePasswordCompanyDAOInterface;
import com.watercooler.entities.UsernamePasswordApplicant;
import com.watercooler.entities.UsernamePasswordCompany;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUsernamePasswordCreateAndCheck {

    UsernamePasswordApplicantDAOInterface usernamePasswordApplicationDAO = new UsernamePasswordApplicantDAOImp();

    @Test
    public void createApplicantSuccess() {
        UsernamePasswordApplicant newApplicant = new UsernamePasswordApplicant(1, "Coloniel", "Popeyes");
        UsernamePasswordApplicant resultingApplicant = usernamePasswordApplicationDAO.createAccountApplicant(newApplicant);
        Assert.assertNotEquals(resultingApplicant.getApplicantId(), 0);

    }

    UsernamePasswordCompanyDAOInterface usernamePasswordCompanyDAO = new UsernamePasswordCompanyDAOImp();


    @Test
    public void createCompanyPersonSuccess() {
        UsernamePasswordCompany newCompanyPerson = new UsernamePasswordCompany(5, "Soysauce", "Ambrosia");
        UsernamePasswordCompany resultingCompanyPerson = usernamePasswordCompanyDAO.createAccountCompany(newCompanyPerson);
        Assert.assertNotEquals(resultingCompanyPerson.getCompanyId(), 5);
    }

    @Test
    public void selectApplicantByIdSuccess() {
        UsernamePasswordApplicant usernamePasswordApplicant = usernamePasswordApplicationDAO.selectApplicantById(1);
        Assert.assertEquals(usernamePasswordApplicant.getApplicantId(), 1);
    }

    @Test
    public void selectCompanyByIdSuccess() {
        UsernamePasswordCompany usernamePasswordCompany = usernamePasswordCompanyDAO.selectCompanyAccountById(1);
        Assert.assertEquals(usernamePasswordCompany.getCompanyId(), 1);
    }

}