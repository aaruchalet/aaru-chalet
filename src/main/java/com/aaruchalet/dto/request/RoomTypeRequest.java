package com.aaruchalet.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoomTypeRequest {
  private Long id;

  @NotBlank(message = "Type name is required")
  private String typeName;

  @NotNull(message = "Price per night is required")
  @Positive(message = "Price per night must be greater than 0")
  private BigDecimal pricePerNight;
}
