package com.example.managementcustomers.service;

import com.example.managementcustomers.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private List<Customer> customerList = new ArrayList<>();

    public CustomerServiceImpl() {
        customerList.add(new Customer(1, "Nguyen Khac Nhat", "nhat@codegym.vn", "Ha Noi"));
        customerList.add(new Customer(2, "Dang Huy Hoa", "hoa.dang@codegym.vn", "Da Nang"));
        customerList.add(new Customer(3, "Le Thi Chau", "chau.le@codegym.vn", "Ha Noi"));
        customerList.add(new Customer(4, "Nguyen Thuy Duong", "duong.nguyen@codegym.vn", "Sai Gon"));
        customerList.add(new Customer(5, "CodeGym", "codegym@codegym.vn", "Viet Nam"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerList;
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerList.get(id - 1);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer existingCustomer = customerList.get(customer.getId() - 1);
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setAddress(customer.getAddress());
    }
}
