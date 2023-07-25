package com.wallet.service.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

	@Id
	private String walletId;
	private String userId;
	private String beneficiaryDetailId;
	private Double balance;
	@Transient
	private List<BeneficiaryDetail> beneficiaryDetails = new ArrayList<>();
}
