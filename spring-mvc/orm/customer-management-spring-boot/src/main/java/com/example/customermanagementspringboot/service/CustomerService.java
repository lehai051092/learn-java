package com.example.customermanagementspringboot.service;

import com.example.customermanagementspringboot.model.Customer;
import com.example.customermanagementspringboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }

    @Override
    public void update(Long id, Customer customer) {
        findById(id);
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        customerRepository.deleteById(id);
    }
}
