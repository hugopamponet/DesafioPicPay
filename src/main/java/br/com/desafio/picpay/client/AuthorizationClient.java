package br.com.desafio.picpay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.desafio.picpay.DTO.AuthorizationDTO;

@FeignClient(
	    name = "authorization-service",
	    url = "https://mocki.io"
	)
public interface AuthorizationClient {

	@GetMapping("/v1/997bab7f-6b6e-4f17-9347-aa32b5312f05")
	ResponseEntity<AuthorizationDTO> isAuthorized();
}