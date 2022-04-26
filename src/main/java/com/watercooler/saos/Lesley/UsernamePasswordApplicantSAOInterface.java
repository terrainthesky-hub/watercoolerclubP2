package com.watercooler.saos.Lesley;

import com.watercooler.entities.Lesley.UsernamePasswordApplicant;

public interface UsernamePasswordApplicantSAOInterface {

    UsernamePasswordApplicant catchErrorsAccountApplicant(UsernamePasswordApplicant checkApplicant);

    UsernamePasswordApplicant selectApplicantById(int id);

    int catchErrorsUnPwApplicant(UsernamePasswordApplicant checkApplicant);

}
