package demoSpringBoot_2.exceptionhandling;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionhandling {
	
	@ExceptionHandler(value= NullPointerException.class)
	public String handlenull(NullPointerException e)
	{
		return "user name is null";
	}
	
	@ExceptionHandler(value= ArithmeticException.class)
	public String handleArithmeticException(ArithmeticException e)
	{
		return "Don't divide by zero";
	}
	
	@ExceptionHandler(value=Exception.class)
	public String handleall(Exception e)
	{
		return "Hadled All don't worry";
	}
}



