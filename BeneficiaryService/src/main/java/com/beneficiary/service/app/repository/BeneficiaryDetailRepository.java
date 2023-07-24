package com.beneficiary.service.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beneficiary.service.app.entity.BeneficiaryDetail;

public interface BeneficiaryDetailRepository extends JpaRepository<BeneficiaryDetail, String>{

	/*
	 * Custom methods
	 */
}
