package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
@ControllerAdvice
public class NoEmpFoundExcep extends RuntimeException {

	public NoEmpFoundExcep(String string) {

		super(string);

	}

	public NoEmpFoundExcep() {
		// TODO Auto-generated constructor stub
	}

}
