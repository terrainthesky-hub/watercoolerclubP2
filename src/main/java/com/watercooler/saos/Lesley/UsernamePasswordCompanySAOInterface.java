package com.watercooler.saos.Lesley;

import com.watercooler.entities.Lesley.UsernamePasswordCompany;

public interface UsernamePasswordCompanySAOInterface {

    UsernamePasswordCompany catchErrorsUsernamePasswordCompany(UsernamePasswordCompany checkCompany);

    UsernamePasswordCompany selectCompanyById(int id);

    int catchErrorsUnPwCompany(UsernamePasswordCompany checkCompany);
}
