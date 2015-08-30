package br.com.nt.address.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.nt.exception.AddressInvalidException;
import br.com.nt.exception.ZipCodeInvalidException;

@ControllerAdvice
public class AddressCepController {

	@ExceptionHandler(value = ZipCodeInvalidException.class)
	public ResponseEntity<Error> handle(ZipCodeInvalidException e){
		return ResponseEntity.badRequest().body(new Error(e));
	}

	@ExceptionHandler(value = AddressInvalidException.class)
	public ResponseEntity<Error> handle(AddressInvalidException e){
		return ResponseEntity.badRequest().body(new Error(e));
	}

}
