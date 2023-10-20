package com.employee.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.salary.IdNotFoundException;
import com.employee.salary.SalaryNotFoundException;

@RestControllerAdvice
public class GlobalHandling {
@ExceptionHandler(IdNotFoundException.class)
public ResponseEntity<Object> idHandling(){
	return new ResponseEntity<>("sorry this is invalid id",HttpStatus.BAD_REQUEST);
}



@ExceptionHandler(SalaryNotFoundException.class)
public ResponseEntity<Object> salaryHandling(){
	return new ResponseEntity<>("bad salay",HttpStatus.BAD_GATEWAY);
}
}
