package br.com.desafio.picpay.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import br.com.desafio.picpay.DTO.TransferDTO;
import br.com.desafio.picpay.entity.Transfer;
import br.com.desafio.picpay.entity.Wallet;
import br.com.desafio.picpay.exception.InsufficientBalanceException;
import br.com.desafio.picpay.exception.TransferNotAllowedForWalletTypeException;
import br.com.desafio.picpay.exception.TransferNotAuthorizedException;
import br.com.desafio.picpay.exception.WalletNotFoundException;
import br.com.desafio.picpay.repository.TransferRepository;
import br.com.desafio.picpay.repository.WalletRepository;
import jakarta.transaction.Transactional;

@Service
public class TransferService {

	private final NotificationService notificationService;
	private final AuthorizationService authorizationService;
	private final TransferRepository transferRepository;
	private final WalletRepository walletRepository;

	public TransferService(NotificationService notificationService, AuthorizationService authorizationService,
			WalletRepository walletRepository, TransferRepository transferRepository) {
		this.notificationService = notificationService;
		this.authorizationService = authorizationService;
		this.walletRepository = walletRepository;
		this.transferRepository = transferRepository; 
	}

	@Transactional
	public Transfer transfer(TransferDTO transferDTO) {
		var sender = walletRepository.findById(transferDTO.payer())
			.orElseThrow(() -> new WalletNotFoundException(transferDTO.payer()));
		
		var receiver = walletRepository.findById(transferDTO.payee())
				.orElseThrow(() -> new WalletNotFoundException(transferDTO.payee()));
		
		validateTransfer(transferDTO, sender);
		
		sender.debit(transferDTO.value());
		receiver.credit(transferDTO.value());
		
		var transfer = new Transfer(sender, receiver, transferDTO.value());
		
		transferRepository.save(transfer);
		walletRepository.save(sender);
		walletRepository.save(receiver);
		var transferResult = transferRepository.save(transfer);
		
		CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));
		
		return transferResult;
	}
	
	public void validateTransfer(TransferDTO transferDTO, Wallet sender) {
		if (!sender.isTransferAllowedForWalletType()) {
			throw new TransferNotAllowedForWalletTypeException();
		}
		
		if (!sender.isBalancerBiggerThan(transferDTO.value())) {
			throw new InsufficientBalanceException();
		}
		
		if (!authorizationService.isAuthorized(transferDTO)) {
			throw new TransferNotAuthorizedException();
		}
	}
}