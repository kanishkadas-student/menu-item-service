package com.cts.menuitem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.menuitem.exception.MenuItemNotFoundException;
import com.cts.menuitem.model.Status;

@RestControllerAdvice
public class GlobalErrorHandler {
    //item not found exception handled
	@ExceptionHandler(MenuItemNotFoundException.class)
	public Status handleNotFoundError(MenuItemNotFoundException ex) {
		Status re = new Status(400, ex.getMessage(), null);
		return re;
	}

	@ExceptionHandler(Exception.class)
	public Status handleNotFoundError2(Exception ex) {
		Status re = new Status(400, ex.getMessage(), null);
		return re;
	}

}
