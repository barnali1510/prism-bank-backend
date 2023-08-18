package com.wellsfargo.training.prism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.prism.model.Customer;
import com.wellsfargo.training.prism.service.CustomerService;

@RestController
@RequestMapping(value="/account")
public class CustomerController {
	
	@Autowired
	private CustomerService CService;
	
	@PostMapping(value="/create")
	public ResponseEntity<String> createCustomet(@RequestBody @Validated Customer c) {

		Customer accountHolder = CService.registerCustomer(c);
		
		if(accountHolder != null)
		return ResponseEntity.ok("Your account has been created and you account number is " + accountHolder.getAccountNo());
		return ResponseEntity.badRequest().body("Registration Failed");
	}

}
