package com.watercooler.daos;

import com.watercooler.entities.UsernamePasswordApplicant;

public interface UsernamePasswordApplicantDAOInterface {

    UsernamePasswordApplicant checkAccountApplicant(UsernamePasswordApplicant checkApplicant);
}
