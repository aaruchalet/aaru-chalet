package com.aaruchalet.controller;

import com.aaruchalet.dto.common.ApiResponse;
import com.aaruchalet.dto.request.CustomerRequest;
import com.aaruchalet.dto.response.CustomerResponse;
import com.aaruchalet.service.CustomerService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

  private CustomerService customerService;

  @GetMapping
  public ResponseEntity<ApiResponse<?>> findAll() {
    List<CustomerResponse> customerResponseList = customerService.findAll();
    if (customerResponseList.isEmpty())
      return ResponseEntity.ok().body(ApiResponse.success("No Customers Present In Database"));
    else
      return ResponseEntity.ok().body(ApiResponse.success(customerResponseList));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<CustomerResponse>> findById(@PathVariable Long id) {
    return ResponseEntity.ok().body(ApiResponse.success(customerService.findById(id)));
  }

  @PostMapping
  public ResponseEntity<ApiResponse<CustomerResponse>> createCustomer(@Valid @RequestBody CustomerRequest request) {
    return ResponseEntity.ok().body(ApiResponse.success(customerService.create(request)));
  }
}