package com.grupo2.eventos.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

public class ErrorUtilsTestUnit {

	MethodArgumentNotValidException exception;
	HttpHeaders headers;
	HttpStatus status;
	WebRequest request;

	@BeforeEach
	void setUp() {

	}

	@Test
	void shouldCreateCustomErrorJson() {

	}

}
