package com.gaowtam.restcrud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //this tis global exception handler
public class StudentRestExceptionHandler {

    //add exception handling code here

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exp) //Global Exception handler er jonno [http://localhost:8080/api/students/sdfsdf]
    {
        //create a StudentErrorResponse

        StudentErrorResponse error=new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exp.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
