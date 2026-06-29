package com.aaruchalet.service;

import com.aaruchalet.dto.request.CustomerRequest;
import com.aaruchalet.dto.response.CustomerResponse;
import java.util.List;

public interface CustomerService {
  List<CustomerResponse> findAll();

  CustomerResponse findById(Long id);

  CustomerResponse findByPhone(String name);

  CustomerResponse findByEmail(String email);

  CustomerResponse create(CustomerRequest request);
}
