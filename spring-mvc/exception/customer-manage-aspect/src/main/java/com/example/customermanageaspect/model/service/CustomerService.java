package com.example.customermanageaspect.model.service;

import com.example.customermanageaspect.model.Customer;
import com.example.customermanageaspect.model.interfaces.ICustomerService;
import com.example.customermanageaspect.model.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void create(Customer customer) {
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
    public void remove(Long id) {
        findById(id);
        customerRepository.deleteById(id);
    }
}
