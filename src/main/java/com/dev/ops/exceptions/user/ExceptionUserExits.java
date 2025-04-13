package com.dev.ops.exceptions.user;

public class ExceptionUserExits extends RuntimeException {

  public ExceptionUserExits(String message) {
    super(message);
  }

  public ExceptionUserExits() {
    super();
  }

}
