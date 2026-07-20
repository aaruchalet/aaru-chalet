package com.chalet.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookingStatus {
  HELD("Held"),          // Reserved for 10 minutes
  CONFIRMED("Confirmed"),// Payment successful
  CANCELLED("Cancelled"),// User cancelled
  EXPIRED("Expired");    // Hold timed out

  private final String value;
}
