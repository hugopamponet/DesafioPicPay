package br.com.desafio.picpay.service;

import org.springframework.stereotype.Service;

import br.com.desafio.picpay.DTO.CreateWalletDto;
import br.com.desafio.picpay.entity.Wallet;
import br.com.desafio.picpay.exception.CustomerExistsException;
import br.com.desafio.picpay.repository.WalletRepository;

@Service
public class WalletService {

	private final WalletRepository walletRepository;
	
	public WalletService(WalletRepository walletRepository) {
		this.walletRepository = walletRepository;
	}
	
	public Wallet createWallet(CreateWalletDto dto) {
		var walletdb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
		
		if (walletdb.isPresent()) {
			throw new CustomerExistsException("CPF or CNPJ or EMAIL already exists");
		} 
		
		return walletRepository.save(dto.toWallet());
	}
}
