package com.aaruchalet.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import lombok.Data;

@Data
public class BookingRequest {
  @NotNull
  private Long customerId;

  @NotNull
  private Long roomTypeId;

  @Pattern(regexp = "^[0-9]{10}$")
  private String phoneNumber;

  private RoomTypeRequest roomTypeRequest;

  @NotNull
  private LocalDate checkInDate;

  @NotNull
  private LocalDate checkOutDate;
}
