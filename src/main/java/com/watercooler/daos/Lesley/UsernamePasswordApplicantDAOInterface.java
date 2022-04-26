package com.watercooler.daos.Lesley;

import com.watercooler.entities.Lesley.UsernamePasswordApplicant;


public interface UsernamePasswordApplicantDAOInterface {

    UsernamePasswordApplicant createAccountApplicant(UsernamePasswordApplicant createdApplicant);

    UsernamePasswordApplicant selectApplicantById(int id);

    int verifyUsernamePasswordApplicant(UsernamePasswordApplicant UnPw);
}
