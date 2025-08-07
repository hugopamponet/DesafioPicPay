package br.com.desafio.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InsufficientBalanceException extends PicpayException{

	@Override
	public ProblemDetail toProblemDetail() {
		var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
		
		pb.setTitle("Insufficient balance");
		pb.setDetail("You cannot transfer a value bigger than your current balance.");
		
		return pb;
	}
}
