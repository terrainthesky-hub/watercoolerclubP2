package com.watercooler.saos;

import com.watercooler.entities.UsernamePasswordApplicant;
import com.watercooler.entities.UsernamePasswordCompany;

public interface UsernamePasswordCompanySAOInterface {

    UsernamePasswordCompany catchErrorsUsernamePasswordCompany(UsernamePasswordCompany checkCompany);

    UsernamePasswordCompany selectCompanyById(int id);

    int catchErrorsUnPwCompany(UsernamePasswordCompany checkCompany);
}
