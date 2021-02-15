package com.fausto.bookstore.resources.exception;

import java.util.ArrayList;
import java.util.List;

import com.fausto.bookstore.exceptions.FieldMessage;

public class ValidationError extends StandardError {

	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
		// TODO Auto-generated constructor stub
	}
	
	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}


}
