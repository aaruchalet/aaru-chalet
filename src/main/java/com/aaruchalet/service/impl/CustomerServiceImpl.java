package com.aaruchalet.service.impl;

import com.aaruchalet.dto.request.CustomerRequest;
import com.aaruchalet.dto.response.CustomerResponse;
import com.aaruchalet.exception.DuplicateResourceException;
import com.aaruchalet.exception.ResourceNotFoundException;
import com.aaruchalet.mapper.CustomerMapper;
import com.aaruchalet.repository.CustomerRepository;
import com.aaruchalet.service.CustomerService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.aaruchalet.util.Constants.CUSTOMER_EMAIL_ALREADY_EXISTS;
import static com.aaruchalet.util.Constants.CUSTOMER_NOT_FOUND;
import static com.aaruchalet.util.Constants.CUSTOMER_PHONE_NUMBER_ALREADY_EXISTS;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  @Override
  public List<CustomerResponse> findAll() {
    return customerMapper.toDto(customerRepository.findAll());
  }

  @Override
  public CustomerResponse findById(Long id) {
    return customerMapper.toDto(customerRepository.findById(id)
            .orElseThrow(() -> (new ResourceNotFoundException(CUSTOMER_NOT_FOUND.formatted(id)))));
  }

  @Override
  @Transactional
  public CustomerResponse create(CustomerRequest request) {
    if (customerRepository.existsByEmail(request.getEmail())) {
      throw new DuplicateResourceException(CUSTOMER_EMAIL_ALREADY_EXISTS);
    }

    if (customerRepository.existsByPhone(request.getPhone())) {
      throw new DuplicateResourceException(CUSTOMER_PHONE_NUMBER_ALREADY_EXISTS);
    }

    return customerMapper.toDto(customerRepository.save(customerMapper.toEntity(request)));
  }

  @Override
  public CustomerResponse findByPhone(String name) {
    return null;
  }

  @Override
  public CustomerResponse findByEmail(String email) {
    return null;
  }
}
