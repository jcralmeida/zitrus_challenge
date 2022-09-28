package com.almeidajcr.backend.exception;

/**
 * Custom exception to be thrown when an object is not found.
 */
public class NotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public NotFoundException(String msg) {
    super(msg);
  }
}