package br.com.desafio.picpay.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.picpay.entity.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, UUID>{

}
