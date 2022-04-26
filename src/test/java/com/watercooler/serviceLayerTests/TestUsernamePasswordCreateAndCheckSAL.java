package com.watercooler.serviceLayerTests;

import com.watercooler.daos.UsernamePasswordApplicantDAOImp;
import com.watercooler.daos.UsernamePasswordApplicantDAOInterface;
import com.watercooler.daos.UsernamePasswordCompanyDAOImp;
import com.watercooler.entities.UsernamePasswordApplicant;
import com.watercooler.entities.UsernamePasswordCompany;
import com.watercooler.saos.UsernamePasswordApplicantSAOImp;
import com.watercooler.saos.UsernamePasswordApplicantSAOInterface;
import com.watercooler.saos.UsernamePasswordCompanySAOImp;
import com.watercooler.utilities.CustomUncheckedException;
import org.testng.Assert;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUsernamePasswordCreateAndCheckSAL {

    public static UsernamePasswordApplicantSAOImp usernamePasswordApplicantSAOImp;
    public static UsernamePasswordApplicantDAOImp usernamePasswordApplicantDAOImp;
    public static UsernamePasswordCompanySAOImp usernamePasswordCompanySAOImp;
    public static UsernamePasswordCompanyDAOImp usernamePasswordCompanyDAOImp;

    @BeforeClass
    public void setup() {
        usernamePasswordApplicantDAOImp = Mockito.mock(UsernamePasswordApplicantDAOImp.class);
        usernamePasswordApplicantSAOImp = new UsernamePasswordApplicantSAOImp(usernamePasswordApplicantDAOImp);

        usernamePasswordCompanyDAOImp = Mockito.mock(UsernamePasswordCompanyDAOImp.class);
        usernamePasswordCompanySAOImp = new UsernamePasswordCompanySAOImp(usernamePasswordCompanyDAOImp);


    }

    UsernamePasswordApplicantDAOInterface DAO = new UsernamePasswordApplicantDAOImp();

//    UsernamePasswordApplicantSAOInterface SAO = new UsernamePasswordApplicantSAOImp();

    @Test(expectedExceptions = CustomUncheckedException.class, expectedExceptionsMessageRegExp = "Username needs to be less than 25 characters")
    public void createApplicantUsernameTooLong() {
        UsernamePasswordApplicant newApplicant = new UsernamePasswordApplicant(1, "This is a long string I'm making, hopefully it will be over 25 ", "Popeyes");
        usernamePasswordApplicantSAOImp.catchErrorsAccountApplicant(newApplicant);}

    @Test(expectedExceptions = CustomUncheckedException.class, expectedExceptionsMessageRegExp = "Username needs to be at least 5 characters")
    public void createApplicantUsernameTooShort() {
        UsernamePasswordApplicant newApplicant = new UsernamePasswordApplicant(1, "wut", "Popeyes");
        usernamePasswordApplicantSAOImp.catchErrorsAccountApplicant(newApplicant);}

    @Test(expectedExceptions = CustomUncheckedException.class, expectedExceptionsMessageRegExp = "Password needs to be less than 25 characters")
    public void createApplicantPasswordTooLong() {
        UsernamePasswordApplicant newApplicant = new UsernamePasswordApplicant(1, "Reasonable string", "Popeyes, pretty good when it's fresh but when it's been under the heat lamp for hours not so much");
        usernamePasswordApplicantSAOImp.catchErrorsAccountApplicant(newApplicant);
    }
    @Test(expectedExceptions = CustomUncheckedException.class, expectedExceptionsMessageRegExp = "Password needs to be at least 5 characters")
    public void createApplicantPasswordTooShort() {
        UsernamePasswordApplicant newApplicant = new UsernamePasswordApplicant(1, "Reasonable string", "wut?");
        usernamePasswordApplicantSAOImp.catchErrorsAccountApplicant(newApplicant);
    }
    @Test(expectedExceptions = CustomUncheckedException.class, expectedExceptionsMessageRegExp = "Username needs to be less than 25 characters")
    public void createCompanyUsernameTooLong() {
        UsernamePasswordCompany newCompany = new UsernamePasswordCompany(1, "This is a long string I'm making, hopefully it will be over 25 ", "Popeyes");
        usernamePasswordCompanySAOImp.catchErrorsUsernamePasswordCompany(newCompany);}

    @Test(expectedExceptions = CustomUncheckedException.class, expectedExceptionsMessageRegExp = "Username needs to be at least 5 characters")
    public void createCompanyUsernameTooShort() {
        UsernamePasswordCompany newCompany = new UsernamePasswordCompany(1, "wut", "Popeyes");
        usernamePasswordCompanySAOImp.catchErrorsUsernamePasswordCompany(newCompany);}

    @Test(expectedExceptions = CustomUncheckedException.class, expectedExceptionsMessageRegExp = "Password needs to be less than 25 characters")
    public void createCompanyPasswordTooLong() {
        UsernamePasswordCompany newCompany = new UsernamePasswordCompany(1, "a fine string", "This is a long string I'm making, hopefully it will be over 25. Definitely over 25 now");
        usernamePasswordCompanySAOImp.catchErrorsUsernamePasswordCompany(newCompany);}

    @Test(expectedExceptions = CustomUncheckedException.class, expectedExceptionsMessageRegExp = "Password needs to be at least 5 characters")
    public void createCompanyPasswordTooShort() {
        UsernamePasswordCompany newCompany = new UsernamePasswordCompany(1, "a fine string", "wut?");
        usernamePasswordCompanySAOImp.catchErrorsUsernamePasswordCompany(newCompany);}

    @Test
    public void createApplicantUsernameTooLongNonMock() {
        try{ UsernamePasswordApplicant newApplicant = new UsernamePasswordApplicant(1, "This is a long string I'm making, hopefully it will be over 25 ", "Popeyes");
        String result  = String.valueOf(usernamePasswordApplicantSAOImp.catchErrorsAccountApplicant(newApplicant));
        Assert.fail();
    }
        catch (CustomUncheckedException e){
            Assert.assertEquals(e.getMessage(), "Username needs to be less than 25 characters");
        }

    }

    @Test
    public void createApplicantUsernameTooShortNonMock() {
        try{ UsernamePasswordApplicant newApplicant = new UsernamePasswordApplicant(1, "wut", "Popeyes");
            String result  = String.valueOf(usernamePasswordApplicantSAOImp.catchErrorsAccountApplicant(newApplicant));
            Assert.fail();
        }
        catch (CustomUncheckedException e){
            Assert.assertEquals(e.getMessage(), "Username needs to be at least 5 characters");
        }

    }

    @Test
    public void createApplicantPasswordTooLongNonMock() {
        try{ UsernamePasswordApplicant newApplicant = new UsernamePasswordApplicant(1, "this is fine ", "This is a long string I'm making, hopefully it will be over 25");
            String result  = String.valueOf(usernamePasswordApplicantSAOImp.catchErrorsAccountApplicant(newApplicant));
            Assert.fail();
        }
        catch (CustomUncheckedException e){
            Assert.assertEquals(e.getMessage(), "Password needs to be less than 25 characters");
        }

    }

    @Test
    public void createApplicantPasswordTooShortNonMock() {
        try{ UsernamePasswordApplicant newApplicant = new UsernamePasswordApplicant(1, "This is fine", "wut");
            String result  = String.valueOf(usernamePasswordApplicantSAOImp.catchErrorsAccountApplicant(newApplicant));
            Assert.fail();
        }
        catch (CustomUncheckedException e){
            Assert.assertEquals(e.getMessage(), "Password needs to be at least 5 characters");
        }

    }

}




