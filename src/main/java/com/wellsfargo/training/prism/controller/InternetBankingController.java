package com.wellsfargo.training.prism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.prism.exception.ResourceNotFoundException;
import com.wellsfargo.training.prism.model.InternetBankingUser;
import com.wellsfargo.training.prism.service.InternetBankingService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value="/ib")
public class InternetBankingController {
	@Autowired
	private InternetBankingService IBService;
	
	@PostMapping(value="/register")
	public ResponseEntity<String> createDealer(@RequestBody @Validated InternetBankingUser ibc){

		
		InternetBankingUser registeredUser = IBService.registerUser(ibc);
		
		if(registeredUser != null)
		return ResponseEntity.ok("You are successfully registered for Internet Banking ");
		
		return ResponseEntity.badRequest().body("Registration Failed");
	}
	@PostMapping(value="/login")
	public Boolean loginCustomer(@RequestBody @Validated InternetBankingUser ibc) throws ResourceNotFoundException{
		Boolean a = false;

		Long accountNumber = ibc.getAccountNumber();
		String password = ibc.getPassword();
		InternetBankingUser login= IBService.loginUser(accountNumber).orElseThrow(() ->
		new ResourceNotFoundException("Customer not found for this id :: "));
		
		if(accountNumber.equals(login.getAccountNumber()) && password.equals(login.getPassword()))
		{
			a=true;

		}

		return a;
	}
}