package com.peppermoney.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.peppermoney.exception.IncomeNotFoundException;

import java.util.*;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class IncomeControllerExceptionHandling {
	
	@ExceptionHandler(IncomeNotFoundException.class)
    public ResponseEntity<?> incomeNotFoundExceptionMethod(IncomeNotFoundException incomeNotFound){
        Map<String, Object> errorBody = new LinkedHashMap<>();

        errorBody.put("error", "Creation Failed");
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("details", incomeNotFound.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.NOT_FOUND);
    }

}
