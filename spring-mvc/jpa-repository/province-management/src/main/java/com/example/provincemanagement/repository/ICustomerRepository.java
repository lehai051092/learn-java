package com.example.provincemanagement.repository;

import com.example.provincemanagement.model.Customer;
import com.example.provincemanagement.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(Pageable pageable, String name);
}
