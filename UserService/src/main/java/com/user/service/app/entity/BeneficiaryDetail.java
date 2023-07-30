package com.user.service.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryDetail {
	
	
	private String beneficiaryDetailId;
	private String userId;
	private String beneficiaryName;
	private String beneficiaryAccountNo;
	private String IFSC;
	private String bankName;
	private String branchName;
	private Double accountBalance;
}
