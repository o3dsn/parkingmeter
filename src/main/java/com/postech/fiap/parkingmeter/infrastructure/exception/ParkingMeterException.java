package com.postech.fiap.parkingmeter.infrastructure.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ParkingMeterException extends RuntimeException {

  private final HttpStatus status;

  public ParkingMeterException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }
}
