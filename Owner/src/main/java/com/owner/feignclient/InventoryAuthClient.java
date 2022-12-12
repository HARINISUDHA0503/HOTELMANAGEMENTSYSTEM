package com.owner.feignclient;

import java.util.List;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.owner.model.AuthenticationResponse;



@FeignClient(name="Authentication", url= "http://localhost:9999/auth")
public interface InventoryAuthClient {
	
	

	    
	    @GetMapping("/validate")
	    public AuthenticationResponse getValidity(@RequestHeader("Authorization") String token) ;
	    
	    }

