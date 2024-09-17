package com.example.springcustomermanagementrestful.model.service;

import com.example.springcustomermanagementrestful.api.customer.ICustomerService;
import com.example.springcustomermanagementrestful.model.Customer;
import com.example.springcustomermanagementrestful.model.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public void remove(Long id) {
        if (findById(id).isPresent()) {
            customerRepository.delete(findById(id).get());
        }
    }
}
