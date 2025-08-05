package br.com.desafio.picpay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.desafio.picpay.entity.Transfer;

@FeignClient(
	    name = "notification-service",
	    url = "${client.authorization-service.url}"
	)
public interface NotificationClient {
	
	@PostMapping
	ResponseEntity<Void> sendNotification(@RequestBody Transfer transfer);

}