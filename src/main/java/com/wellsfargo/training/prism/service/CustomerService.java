package com.wellsfargo.training.prism.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.prism.model.Customer;
import com.wellsfargo.training.prism.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository cRepo;
	
	//for registering the new customer
	public Customer registerCustomer(Customer c) {
		return cRepo.save(c);
	}
	
	//to get the list of all customers
	public List<Customer> ListAll() {
		return cRepo.findAll();
	}
	
	//to get a single customer
	public Optional<Customer> getSingleCustomer(long account_no) {
		return cRepo.findById(account_no);
	}
	
	//to delete a single customer
	public void deleteProduct(long account_no) {
		cRepo.deleteById(account_no);
	}

}
