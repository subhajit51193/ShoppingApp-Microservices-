package com.wallet.service.app.controller;

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

import com.wallet.service.app.entity.Wallet;
import com.wallet.service.app.exception.WalletException;
import com.wallet.service.app.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@PostMapping("/add")
	public ResponseEntity<Wallet> createWalletHandler(@RequestBody Wallet Wallet) throws WalletException{
		
		Wallet newWallet = walletService.createWallet(Wallet);
		return new ResponseEntity<>(newWallet,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Wallet>> getAllWalletsHandler() throws WalletException{
		List<Wallet> Wallets = walletService.getAllWallets();
		return new ResponseEntity<List<Wallet>>(Wallets,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Wallet> getWalletByIdhandler(@PathVariable("id") String walletId) throws WalletException{
		Wallet foundWallet = walletService.getWalletById(walletId);
		return new ResponseEntity<Wallet>(foundWallet,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Wallet> deleteWalletHandler(@PathVariable("id") String walletId) throws WalletException{
		Wallet wallet = walletService.getWalletById(walletId);
		Wallet deletedWallet = walletService.deleteWallet(wallet);
		return new ResponseEntity<Wallet>(deletedWallet,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Wallet> updateWalletHandler(@PathVariable("id") String walletId, @RequestBody Wallet wallet) throws WalletException{
		Wallet updatedWallet = walletService.updateWallet(walletId, wallet);
		return new ResponseEntity<Wallet>(updatedWallet,HttpStatus.ACCEPTED);
	}
}
