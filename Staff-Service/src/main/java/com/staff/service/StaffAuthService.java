package com.staff.service;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.staff.feignclient.StaffAuthClient;
import com.staff.model.AuthenticationResponse;



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

	       else  if (role.equals("MANAGER"))
	            return true;
	       else
	           return false;
	       }
}
