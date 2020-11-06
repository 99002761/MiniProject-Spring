package com.sportsapp.exceptions;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;





public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		        String message=ex.getMessage();
		        LocalDateTime timestamp=LocalDateTime.now();
		        List<String>details=Arrays.asList("Wrong media type","Not valid");
		        APIErrors apierrors=new APIErrors(message,timestamp,status,details);
		            return ResponseEntity.status(status).body(apierrors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		 String message=ex.getMessage();
	        LocalDateTime timestamp=LocalDateTime.now();
	        List<String>details=Arrays.asList("missing servlet request params","No params");
	        APIErrors apierrors=new APIErrors(message,timestamp,status,details);
	            return ResponseEntity.status(status).body(apierrors);

	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		  String message=ex.getMessage();
	        LocalDateTime timestamp=LocalDateTime.now();
	        List<String>details=Arrays.asList("type mismatch","invalid");
	        APIErrors apierrors=new APIErrors(message,timestamp,status,details);
	            return ResponseEntity.status(status).body(apierrors);
	}
	
	   @ExceptionHandler(SportNotFoundException.class)
	    public ResponseEntity<Object>
	    handleBookException(SportNotFoundException ex){
	    	String message=ex.getMessage();
	        LocalDateTime timestamp=LocalDateTime.now();
	        List<String>details=Arrays.asList("stadium name is not available");
	        APIErrors apierrors=new APIErrors(message,timestamp,HttpStatus.BAD_REQUEST,details);
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apierrors);
	    	
	    }
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Object>
	    handleOtherException(Exception ex){
	    	String message=ex.getMessage();
	        LocalDateTime timestamp=LocalDateTime.now();
	        List<String>details=Arrays.asList(message);
	        APIErrors apierrors=new APIErrors(message,timestamp,HttpStatus.INTERNAL_SERVER_ERROR,details);
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apierrors);
	    	
	    }

	
	
	

}
