package com.wellsfargo.training.prism.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.prism.model.InternetBankingUser;
import com.wellsfargo.training.prism.repository.InternetBankingRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InternetBankingService {
	@Autowired
	private InternetBankingRepository ibrepo;
	
	public InternetBankingUser registerUser(InternetBankingUser ibc) {
		return ibrepo.save(ibc);
	}
	
	public Optional<InternetBankingUser> loginUser(Long accountNumber) {

		return ibrepo.findById(accountNumber);
	}

}