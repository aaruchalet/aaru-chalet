package com.chalet.core.repository;

import com.chalet.core.entity.DbCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<DbCustomer, Long> {
  boolean existsByEmail(String email);

  boolean existsByPhone(String phone);
}

