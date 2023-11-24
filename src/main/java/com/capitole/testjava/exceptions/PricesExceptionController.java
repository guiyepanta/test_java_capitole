package com.capitole.testjava.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capitole.testjava.dtos.ErrorDTO;

@RestControllerAdvice
public class PricesExceptionController {

    @ExceptionHandler(value = PriceNotFoundException.class)

    public ResponseEntity<ErrorDTO> exception(PriceNotFoundException exception) {
	// Se debería definir una tabla de Codigos de errores para el sistema
	ErrorDTO error = ErrorDTO.builder().code("P-404").message(exception.getMessage()).build();
	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
