package com.watercooler.daos;

import com.watercooler.entities.UsernamePasswordApplicant;
import com.watercooler.entities.UsernamePasswordCompany;

public interface UsernamePasswordCompanyDAOInterface {

    UsernamePasswordCompany createAccountCompany(UsernamePasswordCompany createCompany);

    UsernamePasswordCompany selectCompanyAccountById(int id);

    int verifyUsernamePasswordCompany(UsernamePasswordCompany UnPw);
}
