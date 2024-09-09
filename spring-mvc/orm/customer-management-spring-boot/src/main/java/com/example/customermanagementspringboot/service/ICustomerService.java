package com.example.customermanagementspringboot.service;

import com.example.customermanagementspringboot.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Long id);

    void update(Long id, Customer customer);

    void delete(Long id);
}
