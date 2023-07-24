package com.beneficiary.service.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beneficiary.service.app.entity.BeneficiaryDetail;
import com.beneficiary.service.app.exception.BeneficiaryDetailException;
import com.beneficiary.service.app.repository.BeneficiaryDetailRepository;

@Service
public class BeneficiaryDetailServiceImpl implements BeneficiaryDetailService{

	@Autowired
	private BeneficiaryDetailRepository beneficiaryDetailRepository;
	
	/*
	 * Register or creating BeneficiaryDetail and saving into database
	 */
	@Override
	public BeneficiaryDetail createBeneficiaryDetail(BeneficiaryDetail beneficiaryDetail) throws BeneficiaryDetailException {
		
		//creating random unique BeneficiaryDetailId
		String randomBeneficiaryDetailId = UUID.randomUUID().toString();
		
		beneficiaryDetail.setBeneficiaryDetailId(randomBeneficiaryDetailId);
		BeneficiaryDetail newBeneficiaryDetail =  beneficiaryDetailRepository.save(beneficiaryDetail);
		if (newBeneficiaryDetail != null) {
			return newBeneficiaryDetail;
		}
		else {
			throw new BeneficiaryDetailException("Error Occured");
		}
	}

	/*
	 * Getting all BeneficiaryDetails from database
	 */
	@Override
	public List<BeneficiaryDetail> getAllBeneficiaryDetails() throws BeneficiaryDetailException {
		
		List<BeneficiaryDetail> beneficiaryDetails = beneficiaryDetailRepository.findAll();
		if (beneficiaryDetails.isEmpty()) {
			throw new BeneficiaryDetailException("Empty List");
		}
		else {
			return beneficiaryDetails;
		}
	}

	
	/*
	 * Get particular BeneficiaryDetail based on BeneficiaryDetailId.  
	 */
	@Override
	public BeneficiaryDetail getBeneficiaryDetailById(String id) throws BeneficiaryDetailException {
		
		Optional<BeneficiaryDetail> opt = beneficiaryDetailRepository.findById(id);
		
		if (opt == null) {
			throw new BeneficiaryDetailException("Not found");
		}
		else {
			return opt.get();
		}
	}

	/*
	 * Delete BeneficiaryDetail from database
	 */
	@Override
	public BeneficiaryDetail deleteBeneficiaryDetail(BeneficiaryDetail beneficiaryDetail) throws BeneficiaryDetailException {
		
		if (beneficiaryDetail == null) {
			throw new BeneficiaryDetailException("Not found");
		}
		else {
			beneficiaryDetailRepository.delete(beneficiaryDetail);
			return beneficiaryDetail;
		}
	}

	
	/*
	 * Update BeneficiaryDetail and save new data into database
	 */
	@Override
	public BeneficiaryDetail updateBeneficiaryDetail(String beneficiaryDetailId, BeneficiaryDetail beneficiaryDetail) throws BeneficiaryDetailException {
		
		Optional<BeneficiaryDetail> opt = beneficiaryDetailRepository.findById(beneficiaryDetailId);
		if (opt.isEmpty()) {
			throw new BeneficiaryDetailException("BeneficiaryDetail not found");
		}
		else {
			BeneficiaryDetail foundBeneficiaryDetail = opt.get();
			foundBeneficiaryDetail.setBankName(beneficiaryDetail.getBankName());
			foundBeneficiaryDetail.setBeneficiaryAccountNo(beneficiaryDetail.getBeneficiaryAccountNo());
			foundBeneficiaryDetail.setBeneficiaryName(beneficiaryDetail.getBeneficiaryName());
			foundBeneficiaryDetail.setBranchName(beneficiaryDetail.getBranchName());
			foundBeneficiaryDetail.setAccountBalance(beneficiaryDetail.getAccountBalance());
			foundBeneficiaryDetail.setIFSC(beneficiaryDetail.getIFSC());
			return beneficiaryDetailRepository.save(foundBeneficiaryDetail);
		}
	}

}
