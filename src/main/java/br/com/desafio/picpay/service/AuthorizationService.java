package br.com.desafio.picpay.service;

import org.springframework.stereotype.Service;

import br.com.desafio.picpay.client.AuthorizationClient;
import br.com.desafio.picpay.entity.Transfer;
import br.com.desafio.picpay.exception.PicpayException;

@Service
public class AuthorizationService {

	private final AuthorizationClient authorizationClient;
	
	public AuthorizationService(AuthorizationClient authorizationClient) {
		this.authorizationClient = authorizationClient;
	}
	
	public boolean isAuthorized(Transfer transfer) {
		var resp = authorizationClient.isAuthorized();
		
		if (resp.getStatusCode().isError()) {
			throw new PicpayException();
		}
		
		return resp.getBody().authorized();
	}
}
