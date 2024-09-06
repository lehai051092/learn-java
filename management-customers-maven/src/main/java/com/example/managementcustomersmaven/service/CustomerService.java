package com.example.managementcustomersmaven.service;

import com.example.managementcustomersmaven.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    void updateCustomer(Customer customer);
}
