package br.com.desafio.picpay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.desafio.picpay.DTO.AuthorizationDTO;

@FeignClient(
	    name = "authorization-service",
	    url = "${client.authorization-service.url}"
	)
public interface AuthorizationClient {

	@GetMapping
	ResponseEntity<AuthorizationDTO> isAuthorized();
}