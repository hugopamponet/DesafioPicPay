package br.com.desafio.picpay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.desafio.picpay.exception.PicpayException;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(PicpayException.class)
	public ProblemDetail handlePicpayException(PicpayException e) {
		return e.toProblemDetail();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		var fieldErros = e.getFieldErrors()
				.stream()
				.map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
				.toList();
				
		var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
		
		pd.setTitle("You request parameters didn't validate.");
		pd.setProperty("invalid-params", fieldErros);
		
		return pd;
	}
	
	private record InvalidParam(String name, String reason) {}
}
