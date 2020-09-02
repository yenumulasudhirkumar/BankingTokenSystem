package com.pramati.banking.controller;

import com.pramati.banking.dto.ResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiController {
  public ApiController() {
  }

  public <T> ResponseEntity<ResponseDto<T>> response(String message, HttpStatus status, T result) {
    return new ResponseEntity(new ResponseDto(message, status, result), status);
  }

  public <T> ResponseEntity<ResponseDto<T>> responseWithHeaders(String message, HttpStatus status, T result, HttpHeaders headers) {
    return new ResponseEntity(new ResponseDto(message, status, result), headers, status);
  }
}
