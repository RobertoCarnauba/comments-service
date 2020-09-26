package com.malutech.commets.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.malutech.commets.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class RessourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StardarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest requeste){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StardarError err = new StardarError(System.currentTimeMillis(),status.value(),"Não encontrado", e.getMessage(), requeste.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}

}
