package com.watercooler.saos.Lesley;

import com.watercooler.daos.Lesley.UsernamePasswordCompanyDAOImp;
import com.watercooler.daos.Lesley.UsernamePasswordCompanyDAOInterface;
import com.watercooler.entities.Lesley.UsernamePasswordCompany;
import com.watercooler.utilities.customExceptions.Lesley.CustomUncheckedException;

public class UsernamePasswordCompanySAOImp implements UsernamePasswordCompanySAOInterface {
    public UsernamePasswordCompanyDAOInterface usernamePasswordCompanyDAOImp;

    public UsernamePasswordCompanySAOImp(UsernamePasswordCompanyDAOInterface usernamePasswordCompanyDAOImp) {
        this.usernamePasswordCompanyDAOImp = usernamePasswordCompanyDAOImp;
    }

    UsernamePasswordCompanyDAOInterface DAO = new UsernamePasswordCompanyDAOImp();

    @Override
    public UsernamePasswordCompany catchErrorsUsernamePasswordCompany(UsernamePasswordCompany checkCompany) {
        if (checkCompany.getCompanyUsername().length() > 25) {
            throw new CustomUncheckedException("Username needs to be less than 25 characters");
        } else if (checkCompany.getCompanyPassword().length() > 25) {
            throw new CustomUncheckedException("Password needs to be less than 25 characters");
        } else if (checkCompany.getCompanyUsername().length() <= 5) {
            throw new CustomUncheckedException("Username needs to be at least 5 characters");
        } else if (checkCompany.getCompanyPassword().length() <= 5) {
            throw new CustomUncheckedException("Password needs to be at least 5 characters");
        } else {
            return DAO.createAccountCompany(checkCompany);
        }
    }

    @Override
    public UsernamePasswordCompany selectCompanyById(int id) {
        return DAO.selectCompanyAccountById(id);
    }


    @Override
    public int catchErrorsUnPwCompany(UsernamePasswordCompany checkCompany) {
        if (checkCompany.getCompanyUsername().length() > 25) {
            throw new CustomUncheckedException("Username needs to be less than 25 characters");
        } else if (checkCompany.getCompanyPassword().length() > 25) {
            throw new CustomUncheckedException("Password needs to be less than 25 characters");
        } else if (checkCompany.getCompanyUsername().length() <= 5) {
            throw new CustomUncheckedException("Username needs to be at least 5 characters");
        } else if (checkCompany.getCompanyPassword().length() <= 5) {
            throw new CustomUncheckedException("Password needs to be at least 5 characters");
        } else {
            return DAO.verifyUsernamePasswordCompany(checkCompany);
//            if(result == 0){
//                return 0;
//            } else {
//                return result;
//            }
        }
    }
}


