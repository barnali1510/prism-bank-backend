package com.wellsfargo.training.prism.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.prism.model.InternetBankingUser;

public interface InternetBankingRepository extends JpaRepository<InternetBankingUser, Long>{

}
