package com.roomservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.roomservice.feignclient.RoomAuthClient;
import com.roomservice.model.AuthenticationResponse;

@Service
public class RoomAuthService {
	@Autowired
	private RoomAuthClient roomauthclient;

	public boolean isSessionValid(String token) {

		AuthenticationResponse authenticationResponse = roomauthclient.getValidity(token);
		if (authenticationResponse == null) {
			throw new RuntimeException("Authentication reponse returned as  NULL");
		}

		String role = authenticationResponse.getRole().substring(5);

		if (role.equals("OWNER"))
			return true;

		else if (role.equals("MANAGER"))
		return true;
		else if (role.equals("RECEPTIONIST"))
			return true;
		else
			return false;

	}

}
