package com.watercooler.saos;

import com.watercooler.entities.UsernamePasswordApplicant;

public interface UsernamePasswordApplicantSAOInterface {

    UsernamePasswordApplicant createAccountApplicant(UsernamePasswordApplicant createdApplicant);

    UsernamePasswordApplicant selectApplicantById(int id);
}
