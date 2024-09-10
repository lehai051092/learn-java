package com.example.customermanagementorm.service;

import com.example.customermanagementorm.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateCustomerService implements ICustomerService {

    @Override
    public List<Customer> findAll() {
        return List.of();
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public void remove(int id) {

    }
}
