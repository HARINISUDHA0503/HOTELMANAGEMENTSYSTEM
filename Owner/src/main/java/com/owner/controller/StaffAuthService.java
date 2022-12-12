package com.owner.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.owner.feignclient.StaffAuthClient;
import com.owner.model.AuthenticationResponse;


@Service
public class StaffAuthService {

	@Autowired
    StaffAuthClient staffauthclient;
	
	public boolean isSessionValid(String token) {

	       AuthenticationResponse authenticationResponse = staffauthclient.getValidity(token);
	        if (authenticationResponse == null) {
	            throw new RuntimeException("Authentication reponse returned as  NULL");
	        }

	       String role = authenticationResponse.getRole().substring(5);

	       if (role.equals("OWNER"))
	            return true;

	       else

	           return false;
	       }
}
