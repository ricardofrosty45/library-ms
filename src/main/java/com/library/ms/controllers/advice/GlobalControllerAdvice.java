package com.library.ms.controllers.advice;

import java.sql.SQLTransientConnectionException;

import javax.persistence.QueryTimeoutException;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.library.ms.dto.response.ErrorResponse;
import com.library.ms.exceptions.BookException;
import com.library.ms.exceptions.UserException;

@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value())
				.message(exception.getFieldError().getDefaultMessage()).build(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ CannotGetJdbcConnectionException.class, SQLTransientConnectionException.class,
			JDBCConnectionException.class, QueryTimeoutException.class })
	public ResponseEntity<ErrorResponse> databaseExceptionGeneral() {
		return new ResponseEntity<>(ErrorResponse.builder()
				.message("Connection with database was lost, database is unavaliable right now please, try again later")
				.status(HttpStatus.SERVICE_UNAVAILABLE.value()).build(), HttpStatus.SERVICE_UNAVAILABLE);
	}

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorResponse> clientExcepton(UserException e) {
		return new ResponseEntity<>(
				ErrorResponse.builder().message(e.getMessage()).status(HttpStatus.NOT_FOUND.value()).build(),
				HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(BookException.class)
	public ResponseEntity<ErrorResponse> bookException(BookException e) {
		return new ResponseEntity<>(
				ErrorResponse.builder().message(e.getMessage()).status(HttpStatus.NOT_FOUND.value()).build(),
				HttpStatus.NOT_FOUND);
	}

}
