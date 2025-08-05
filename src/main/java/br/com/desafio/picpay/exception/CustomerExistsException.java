package br.com.desafio.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CustomerExistsException extends PicpayException{
	
	private String detail;
	
	public CustomerExistsException(String detail) {
		this.detail = detail;
	}
	
	@Override
	public ProblemDetail toProblemDetail() {
		var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
		
		pb.setTitle("Wallet data already exists");
		pb.setDetail(detail);;
		
		return pb;
	}

}
