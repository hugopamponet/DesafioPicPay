package br.com.desafio.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.picpay.entity.WalletType;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long>{

}