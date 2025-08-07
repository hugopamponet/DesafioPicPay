package br.com.desafio.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAuthorizedException extends PicpayException{

	@Override
	public ProblemDetail toProblemDetail() {
		var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
		
		pb.setTitle("Transfer not authorized.");
		pb.setDetail("Authorized service not autorized this transfer.");
		
		return pb;
	}
}
