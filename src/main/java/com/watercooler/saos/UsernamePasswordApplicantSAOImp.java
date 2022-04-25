package com.watercooler.saos;

import com.watercooler.daos.UsernamePasswordApplicantDAOImp;
import com.watercooler.daos.UsernamePasswordApplicantDAOInterface;
import com.watercooler.entities.UsernamePasswordApplicant;
import com.watercooler.entities.UsernamePasswordCompany;
import com.watercooler.utilities.CustomUncheckedException;

public class UsernamePasswordApplicantSAOImp implements UsernamePasswordApplicantSAOInterface {

    public UsernamePasswordApplicantDAOInterface usernamePasswordApplicantDAOImp;

    public UsernamePasswordApplicantSAOImp(UsernamePasswordApplicantDAOInterface usernamePasswordApplicantDAOImp) {this.usernamePasswordApplicantDAOImp = usernamePasswordApplicantDAOImp;}

//    UsernamePasswordApplicantDAOInterface DAO = new UsernamePasswordApplicantDAOImp();

    @Override
    public UsernamePasswordApplicant catchErrorsAccountApplicant(UsernamePasswordApplicant checkApplicant) {
            if (checkApplicant.getApplicantUsername().length() > 25) {
                throw new CustomUncheckedException("Username needs to be less than 25 characters");
            } else if (checkApplicant.getApplicantPassword().length() > 25) {
                throw new CustomUncheckedException("Password needs to be less than 25 characters");
            } else if (checkApplicant.getApplicantUsername().length() <= 5) {
            throw new CustomUncheckedException("Username needs to be at least 5 characters");
            } else if (checkApplicant.getApplicantPassword().length() <= 5) {
              throw new CustomUncheckedException("Password needs to be at least 5 characters");
        } else {
                return this.usernamePasswordApplicantDAOImp.createAccountApplicant(checkApplicant);
            }
        }


    @Override
    public UsernamePasswordApplicant selectApplicantById(int id){
        return this.usernamePasswordApplicantDAOImp.selectApplicantById(id);
    }

    @Override
    public int catchErrorsUnPwApplicant(UsernamePasswordApplicant checkApplicant) {
        if (checkApplicant.getApplicantUsername().length() > 25) {
            throw new CustomUncheckedException("Username needs to be less than 25 characters");
        } else if (checkApplicant.getApplicantPassword().length() > 25) {
            throw new CustomUncheckedException("Password needs to be less than 25 characters");
        } else if (checkApplicant.getApplicantUsername().length() <= 5) {
            throw new CustomUncheckedException("Username needs to be at least 5 characters");
        } else if (checkApplicant.getApplicantPassword().length() <= 5) {
            throw new CustomUncheckedException("Password needs to be at least 5 characters");
        } else {
            return usernamePasswordApplicantDAOImp.verifyUsernamePasswordApplicant(checkApplicant);
        }
    }


    }