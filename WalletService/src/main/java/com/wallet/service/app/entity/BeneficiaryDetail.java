package com.wallet.service.app.entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
