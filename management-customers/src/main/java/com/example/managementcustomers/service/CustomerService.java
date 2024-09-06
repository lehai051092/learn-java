package com.example.managementcustomers.service;

import com.example.managementcustomers.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    void updateCustomer(Customer customer);
}
