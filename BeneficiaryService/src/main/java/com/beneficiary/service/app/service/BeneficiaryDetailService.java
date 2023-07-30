package com.beneficiary.service.app.service;

import java.util.List;

import com.beneficiary.service.app.entity.BeneficiaryDetail;
import com.beneficiary.service.app.exception.BeneficiaryDetailException;

public interface BeneficiaryDetailService {

	public BeneficiaryDetail createBeneficiaryDetail(BeneficiaryDetail beneficiaryDetail) throws BeneficiaryDetailException;
	
	public List<BeneficiaryDetail> getAllBeneficiaryDetails() throws BeneficiaryDetailException;
	
	public BeneficiaryDetail getBeneficiaryDetailById(String id) throws BeneficiaryDetailException;
	
	public BeneficiaryDetail deleteBeneficiaryDetail(BeneficiaryDetail beneficiaryDetail)throws BeneficiaryDetailException;
	
	public BeneficiaryDetail updateBeneficiaryDetail(String beneficiaryDetailId,BeneficiaryDetail beneficiaryDetail)throws BeneficiaryDetailException;
	
	public List<BeneficiaryDetail> getBeneficiaryDetailsByUserId(String userId)throws BeneficiaryDetailException;
}
