package com.example.provincemanagement.repository;

import com.example.provincemanagement.model.Customer;
import com.example.provincemanagement.model.Province;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
