package com.watercooler.daos.Lesley;

import com.watercooler.entities.Lesley.UsernamePasswordCompany;

public interface UsernamePasswordCompanyDAOInterface {

    UsernamePasswordCompany createAccountCompany(UsernamePasswordCompany createCompany);

    UsernamePasswordCompany selectCompanyAccountById(int id);

    int verifyUsernamePasswordCompany(UsernamePasswordCompany UnPw);
}
