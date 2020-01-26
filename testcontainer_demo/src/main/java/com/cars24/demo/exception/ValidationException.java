package com.cars24.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ValidationException extends RuntimeException {

  private static final long serialVersionUID = -5886138347268844485L;

  private Integer code;

  private String message;

  public ValidationException(String message) {
    super(message);
    this.message = message;
  }

  public ValidationException(String message, Integer code) {
    super(message);
    this.code = code;
    this.message = message;
  }

  public ValidationException(String message, Throwable cause) {
    super(message, cause);
    this.message = message;
  }

  public ValidationException(String message, Integer code, Throwable cause) {
    super(message, cause);
    this.code = code;
    this.message = message;
  }

}
