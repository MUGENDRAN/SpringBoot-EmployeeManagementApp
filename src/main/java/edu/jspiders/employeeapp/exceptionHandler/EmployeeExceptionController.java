package edu.jspiders.employeeapp.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionController 
{
	@ExceptionHandler(value=IdNotFoundException.class)
	public ResponseEntity<?> idNotFoundExcep(IdNotFoundException exception)
	{
		ApiError error=new ApiError();
		error.setDateTime(LocalDateTime.now());
		error.setExceptionClass(exception.getClass());
		error.setMessage(exception.getMessage());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
