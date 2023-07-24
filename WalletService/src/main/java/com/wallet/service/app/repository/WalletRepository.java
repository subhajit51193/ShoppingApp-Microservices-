package com.wallet.service.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.service.app.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, String>{

}
