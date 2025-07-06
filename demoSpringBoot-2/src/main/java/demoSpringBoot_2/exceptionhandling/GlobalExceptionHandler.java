package demoSpringBoot_2.exceptionhandling;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import demoSpringBoot_2.exception.StudentException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentException.class)
	public String handleStudentsException(StudentException e)
	{
		return "Student-related exception occurred: " + e.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	public String handleAllExceptions(Exception e)
	{
		return "Handled All Exceptions " + e.getMessage();
	}
}
