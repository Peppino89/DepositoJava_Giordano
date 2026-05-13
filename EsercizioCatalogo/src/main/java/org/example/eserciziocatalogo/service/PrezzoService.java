package org.example.eserciziocatalogo.service;

import org.springframework.stereotype.Service;

@Service
public class PrezzoService {

    public double prezzoScontato(double prezzoOriginale, int percentualeSconto){

        return prezzoOriginale - (prezzoOriginale*percentualeSconto)/100;


    }
}
