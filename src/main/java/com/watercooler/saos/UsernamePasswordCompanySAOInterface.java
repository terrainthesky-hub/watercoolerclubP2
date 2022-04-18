package com.watercooler.saos;

import com.watercooler.entities.UsernamePasswordCompany;

public interface UsernamePasswordCompanySAOInterface {

    UsernamePasswordCompany createAccountCompany(UsernamePasswordCompany createCompany);

    UsernamePasswordCompany selectCompanyAccountById(int id);
}
