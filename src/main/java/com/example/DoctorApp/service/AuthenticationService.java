package com.example.DoctorApp.service;

import com.example.DoctorApp.model.AuthenticationToken;
import com.example.DoctorApp.repository.IAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {


    @Autowired
    IAuthTokenRepo iAuthTokenRepo;
    public boolean authenticate(String email,String authTokenValue){

        AuthenticationToken authToken=iAuthTokenRepo.findFirstByTokenValue(authTokenValue);

        if(authToken==null){
            return false;
        }

        String tokenConnectedEmail= authToken.getPatient().getPatientEmail();

        return tokenConnectedEmail.equals(email);
    }

}
