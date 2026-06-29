package com.aaruchalet.repository;

import com.aaruchalet.entity.DbCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<DbCustomer, Long> {
  boolean existsByEmail(String email);

  boolean existsByPhone(String phone);
}

