package com.wallet.service.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.service.app.entity.Wallet;
import com.wallet.service.app.exception.WalletException;
import com.wallet.service.app.repository.WalletRepository;

@Service
public class WalletServiceImpl implements WalletService{

	@Autowired
	private WalletRepository walletRepository;
	
	/*
	 * Register or creating Wallet and saving into database
	 */
	@Override
	public Wallet createWallet(Wallet wallet) throws WalletException {
		
		//creating random unique WalletId
		String randomWalletId = UUID.randomUUID().toString();
		
		wallet.setWalletId(randomWalletId);
		Wallet newWallet =  walletRepository.save(wallet);
		if (newWallet != null) {
			return newWallet;
		}
		else {
			throw new WalletException("Error Occured");
		}
	}

	/*
	 * Getting all Wallets from database
	 */
	@Override
	public List<Wallet> getAllWallets() throws WalletException {
		
		List<Wallet> Wallets = walletRepository.findAll();
		if (Wallets.isEmpty()) {
			throw new WalletException("Empty List");
		}
		else {
			return Wallets;
		}
	}

	
	/*
	 * Get particular Wallet based on WalletId.  
	 */
	@Override
	public Wallet getWalletById(String id) throws WalletException {
		
		Optional<Wallet> opt = walletRepository.findById(id);
		
		if (opt == null) {
			throw new WalletException("Not found");
		}
		else {
			return opt.get();
		}
	}

	/*
	 * Delete Wallet from database
	 */
	@Override
	public Wallet deleteWallet(Wallet wallet) throws WalletException {
		
		if (wallet == null) {
			throw new WalletException("Not found");
		}
		else {
			walletRepository.delete(wallet);
			return wallet;
		}
	}

	
	/*
	 * Update Wallet and save new data into database
	 */
	@Override
	public Wallet updateWallet(String walletId, Wallet wallet) throws WalletException {
		
		Optional<Wallet> opt = walletRepository.findById(walletId);
		if (opt.isEmpty()) {
			throw new WalletException("Wallet not found");
		}
		else {
			Wallet foundWallet = opt.get();
			foundWallet.setBalance(wallet.getBalance());
			return walletRepository.save(foundWallet);
		}
	}

}
