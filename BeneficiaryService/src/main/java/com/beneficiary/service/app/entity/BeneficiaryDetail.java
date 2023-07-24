package com.beneficiary.service.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BeneficiaryDetails")
public class BeneficiaryDetail {

	@Id
	private String beneficiaryDetailId;
	private String beneficiaryName;
	private String beneficiaryAccountNo;
	private String IFSC;
	private String bankName;
	private String branchName;
	private Double accountBalance;
}
