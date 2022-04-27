package com.watercooler.saos;

import com.watercooler.entities.UsernamePasswordApplicant;

public interface UsernamePasswordApplicantSAOInterface {

    UsernamePasswordApplicant catchErrorsAccountApplicant(UsernamePasswordApplicant checkApplicant);

    UsernamePasswordApplicant selectApplicantById(int id);

    int catchErrorsUnPwApplicant(UsernamePasswordApplicant checkApplicant);

}
