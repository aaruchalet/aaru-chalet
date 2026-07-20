package com.chalet.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoomStatus {
  READY("Ready"),
  OCCUPIED("Occupied"),
  CLEANING("Cleaning"),
  MAINTENANCE("Maintenance"),
  AVAILABLE("Available");

  private final String value;
}
