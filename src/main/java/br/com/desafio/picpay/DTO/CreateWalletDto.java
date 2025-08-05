package br.com.desafio.picpay.DTO;

import br.com.desafio.picpay.entity.Wallet;
import br.com.desafio.picpay.entity.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateWalletDto(@NotBlank String nameFull, @NotBlank String cpfCnpj, @NotBlank String email, @NotBlank String password, 
		@NotNull WalletType.Enum walletType) {
	
	public Wallet toWallet() {
		return new Wallet(
				nameFull,
				cpfCnpj,
				email,
				password,
				walletType.get()
				);
	}
}
