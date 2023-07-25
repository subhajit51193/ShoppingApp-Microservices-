package com.wallet.service.app.service;
import java.util.List;

import com.wallet.service.app.entity.Wallet;
import com.wallet.service.app.exception.WalletException;

public interface WalletService {

	public Wallet createWallet(Wallet wallet) throws WalletException;
	
	public List<Wallet> getAllWallets() throws WalletException;
	
	public Wallet getWalletById(String id) throws WalletException;
	
	public Wallet deleteWallet(Wallet wallet)throws WalletException;
	
	public Wallet updateWallet(String walletId,Wallet wallet)throws WalletException;
}
