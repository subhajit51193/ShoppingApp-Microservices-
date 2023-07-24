package com.beneficiary.service.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beneficiary.service.app.entity.BeneficiaryDetail;
import com.beneficiary.service.app.exception.BeneficiaryDetailException;
import com.beneficiary.service.app.service.BeneficiaryDetailService;

@RestController
@RequestMapping("/beneficiaryDetail")
public class BeneficiaryDetailController {

	@Autowired
	private BeneficiaryDetailService beneficiaryDetailService;
	
	@PostMapping("/add")
	public ResponseEntity<BeneficiaryDetail> createBeneficiaryDetailHandler(@RequestBody BeneficiaryDetail beneficiaryDetail) throws BeneficiaryDetailException{
		
		BeneficiaryDetail newBeneficiaryDetail = beneficiaryDetailService.createBeneficiaryDetail(beneficiaryDetail);
		return new ResponseEntity<>(newBeneficiaryDetail,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<BeneficiaryDetail>> getAllBeneficiaryDetailsHandler() throws BeneficiaryDetailException{
		List<BeneficiaryDetail> BeneficiaryDetails = beneficiaryDetailService.getAllBeneficiaryDetails();
		return new ResponseEntity<List<BeneficiaryDetail>>(BeneficiaryDetails,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BeneficiaryDetail> getBeneficiaryDetailByIdhandler(@PathVariable("id") String beneficiaryDetailId) throws BeneficiaryDetailException{
		BeneficiaryDetail foundBeneficiaryDetail = beneficiaryDetailService.getBeneficiaryDetailById(beneficiaryDetailId);
		return new ResponseEntity<BeneficiaryDetail>(foundBeneficiaryDetail,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<BeneficiaryDetail> deleteBeneficiaryDetailHandler(@PathVariable("id") String beneficiaryDetailId) throws BeneficiaryDetailException{
		BeneficiaryDetail beneficiaryDetail = beneficiaryDetailService.getBeneficiaryDetailById(beneficiaryDetailId);
		BeneficiaryDetail deletedBeneficiaryDetail = beneficiaryDetailService.deleteBeneficiaryDetail(beneficiaryDetail);
		return new ResponseEntity<BeneficiaryDetail>(deletedBeneficiaryDetail,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BeneficiaryDetail> updateBeneficiaryDetailHandler(@PathVariable("id") String beneficiaryDetailId, @RequestBody BeneficiaryDetail beneficiaryDetail) throws BeneficiaryDetailException{
		BeneficiaryDetail updatedBeneficiaryDetail = beneficiaryDetailService.updateBeneficiaryDetail(beneficiaryDetailId, beneficiaryDetail);
		return new ResponseEntity<BeneficiaryDetail>(updatedBeneficiaryDetail,HttpStatus.ACCEPTED);
	}
}
