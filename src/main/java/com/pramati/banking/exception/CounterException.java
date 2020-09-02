package com.pramati.banking.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CounterException extends RuntimeException {

  String message;

  public CounterException(String message) {
    this.message = message;
  }
}
