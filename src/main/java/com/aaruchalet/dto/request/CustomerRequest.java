package com.aaruchalet.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerRequest {
  @NotBlank(message = "Customer name is required")
  private String name;

  @NotBlank(message = "Email is required")
  @Email(message = "Invalid email format")
  private String email;

  @NotBlank(message = "Phone number cannot be blank")
  @Pattern(
          regexp = "^[0-9]{10}$",
          message = "Phone number must be exactly 10 digits"
  )
  private String phone;

  private String address;
  private Boolean member;
}
