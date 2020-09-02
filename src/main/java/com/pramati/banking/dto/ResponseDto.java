package com.pramati.banking.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@Setter
public class ResponseDto<T> {
  private String message;
  private HttpStatus responseCode;
  private Map<String, String> errors;
  private T data;

  public ResponseDto() {

  }

  public ResponseDto(String message, HttpStatus responseCode, T data) {
    this.message = message;
    this.responseCode = responseCode;
    this.data = data;
  }

  public ResponseDto(String message, HttpStatus responseCode, Map<String, String> errors, T data) {
    this.message = message;
    this.responseCode = responseCode;
    this.errors = errors;
    this.data = data;
  }
}
