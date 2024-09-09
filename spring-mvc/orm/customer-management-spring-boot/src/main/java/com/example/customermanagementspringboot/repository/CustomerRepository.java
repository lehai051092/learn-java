package com.example.customermanagementspringboot.repository;

import com.example.customermanagementspringboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
