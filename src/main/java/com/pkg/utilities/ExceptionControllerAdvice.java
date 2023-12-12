package com.pkg.utilities;

import java.util.stream.Collectors;

//import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pkg.exception.TicketException;
import com.pkg.utilities.TicketConstants;
import com.pkg.utilities.ErrorInfo;

import jakarta.validation.ConstraintViolationException;

//import jakarta.validation.ConstraintViolationException;
@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@ExceptionHandler(TicketException.class)
	public ResponseEntity<ErrorInfo> ticketExceptionHandler(TicketException exception) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception exception) {
		logger.info(exception.getMessage());
		logger.info(exception.getStackTrace().toString());
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setErrorMessage(TicketConstants.GENERAL_EXCEPTION_MESSAGE.toString());

		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//handler for methodargumentnotvalidexception and ConstraintsViolationException
	@ExceptionHandler({MethodArgumentNotValidException.class,ConstraintViolationException.class})
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception ex) {

		logger.error(ex.getMessage(), ex);

		String errorMessage;

		if (ex instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException mex = (MethodArgumentNotValidException) ex;
			errorMessage = mex.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(", "));
		} else {
			ConstraintViolationException cex = (ConstraintViolationException) ex;
			errorMessage = cex.getConstraintViolations().stream().map(x -> x.getMessage())
					.collect(Collectors.joining(", "));
		}
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMessage(errorMessage);

		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
}
