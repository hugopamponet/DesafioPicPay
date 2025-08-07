package br.com.desafio.picpay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.desafio.picpay.entity.Transfer;

@FeignClient(
	    name = "notification-service",
	    url = "https://mocki.io"
	)
public interface NotificationClient {
	
	@PostMapping("/v1/718f9323-c3ff-45fa-9daf-780086854daa")
	ResponseEntity<Void> sendNotification(@RequestBody Transfer transfer);

}