package br.com.bootcamp.desafiocrud.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<String> clientNotFoundHandler(ResponseStatusException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getReason()); 
	}
}
