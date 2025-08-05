package br.com.desafio.picpay.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.picpay.DTO.CreateWalletDto;
import br.com.desafio.picpay.entity.Wallet;
import br.com.desafio.picpay.service.WalletService;
import jakarta.validation.Valid;

@RestController
public class WalletController {

	private final WalletService walletService;
	
	public WalletController(WalletService walletService) {
		this.walletService = walletService;
	}
	
	@PostMapping("/wallets")
	public ResponseEntity<Wallet> createWaççet(@RequestBody @Valid CreateWalletDto dto) {
		var wallet = walletService.createWallet(dto);
		
		return ResponseEntity.ok(wallet);
	}
}
