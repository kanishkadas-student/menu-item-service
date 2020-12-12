package com.cts.menuitem.model;

import java.util.List;

import org.springframework.validation.FieldError;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Status {

	private int statusCode;// code of the status initialised
	private String message;// message to be displayed in the status initialised
	private List<FieldError> errors;// list of errors initialised 
}
