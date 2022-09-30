package com.almeidajcr.backend.exception;

import com.almeidajcr.backend.enums.ActionEnum;

/**
 * A custom exception to be used when there is not enough
 * product amount to perform an {@link ActionEnum#SAIDA} operation.
 */
public class InsufficientAmountException  extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public InsufficientAmountException(String msg) {
    super(msg);
  }
}
