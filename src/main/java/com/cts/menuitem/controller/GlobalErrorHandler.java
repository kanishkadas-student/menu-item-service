package com.cts.menuitem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.menuitem.exception.MenuItemNotFoundException;

/*@ControllerAdvice
@ResponseBody*/


@RestControllerAdvice
public class GlobalErrorHandler {

	@ExceptionHandler(MenuItemNotFoundException.class)
	public ResponseEntity<String> handleNotFoundError(MenuItemNotFoundException ex){
		ResponseEntity<String> re=new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		return re;
	}
	
}
