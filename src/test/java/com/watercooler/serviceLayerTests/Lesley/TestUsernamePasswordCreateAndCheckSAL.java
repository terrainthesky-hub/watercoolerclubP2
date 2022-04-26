package com.watercooler.serviceLayerTests.Lesley;

import com.watercooler.daos.Lesley.UsernamePasswordApplicantDAOImp;
import com.watercooler.daos.Lesley.UsernamePasswordApplicantDAOInterface;
import com.watercooler.daos.Lesley.UsernamePasswordCompanyDAOImp;
import com.watercooler.entities.Lesley.UsernamePasswordApplicant;
import com.watercooler.entities.Lesley.UsernamePasswordCompany;
import com.watercooler.saos.Lesley.UsernamePasswordApplicantSAOImp;
import com.watercooler.saos.Lesley.UsernamePasswordCompanySAOImp;
import com.watercooler.utilities.customExceptions.Lesley.CustomUncheckedException;
import org.testng.Assert;
import org.mockito.Mockito;

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

    @Test
    public void createCompanyUsernameTooLongNonMock() {
        try{ UsernamePasswordCompany newCompany = new UsernamePasswordCompany(1, "This is a long string I'm making, hopefully it will be over 25 ", "Popeyes");
            String result  = String.valueOf(usernamePasswordCompanySAOImp.catchErrorsUsernamePasswordCompany(newCompany));
            Assert.fail();
        }
        catch (CustomUncheckedException e){
            Assert.assertEquals(e.getMessage(), "Username needs to be less than 25 characters");
        }

    }
    @Test
    public void createCompanyUsernameTooShortNonMock() {
        try{ UsernamePasswordCompany newCompany = new UsernamePasswordCompany(1, "wut", "Popeyes");
            String result  = String.valueOf(usernamePasswordCompanySAOImp.catchErrorsUsernamePasswordCompany(newCompany));
            Assert.fail();
        }
        catch (CustomUncheckedException e){
            Assert.assertEquals(e.getMessage(), "Username needs to be at least 5 characters");
        }

    }

    @Test
    public void createCompanyPasswordTooLongNonMock() {
        try{ UsernamePasswordCompany newCompany = new UsernamePasswordCompany(1, "this is fine ", "This is a long string I'm making, hopefully it will be over 25");
            String result  = String.valueOf(usernamePasswordCompanySAOImp.catchErrorsUsernamePasswordCompany(newCompany));
            Assert.fail();
        }
        catch (CustomUncheckedException e){
            Assert.assertEquals(e.getMessage(), "Password needs to be less than 25 characters");
        }

    }
    @Test
    public void createCompanyPasswordTooShortNonMock() {
        try{ UsernamePasswordCompany newCompany = new UsernamePasswordCompany(1, "This is fine", "wut");
            String result  = String.valueOf(usernamePasswordCompanySAOImp.catchErrorsUsernamePasswordCompany(newCompany));
            Assert.fail();
        }
        catch (CustomUncheckedException e){
            Assert.assertEquals(e.getMessage(), "Password needs to be at least 5 characters");
        }

    }


}




