package com.beneficiary.service.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beneficiary.service.app.entity.BeneficiaryDetail;

public interface BeneficiaryDetailRepository extends JpaRepository<BeneficiaryDetail, String>{

	/*
	 * Custom methods
	 */
	
	List<BeneficiaryDetail> findByUserId(String userId);
}
