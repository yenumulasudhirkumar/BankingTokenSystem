package com.pramati.banking.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserException extends RuntimeException {

  String message;

  public UserException(String message) {
    this.message = message;
  }

}
