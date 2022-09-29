package com.almeidajcr.backend.exception;

import com.almeidajcr.backend.enums.ActionEnum;

/**
 * A custom exception to be used when the clients try to pass the
 * {@link ActionEnum#ENTRADA} and the field saleValue}.
 */
public class InvalidFieldCombinationException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public InvalidFieldCombinationException(String msg) {
    super(msg);
  }
}
