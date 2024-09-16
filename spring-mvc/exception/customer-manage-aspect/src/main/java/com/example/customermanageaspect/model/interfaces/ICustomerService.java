package com.example.customermanageaspect.model.interfaces;

import com.example.customermanageaspect.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void create(Customer customer);

    Customer findById(Long id);

    void update(Long id, Customer customer);

    void remove(Long id);
}
