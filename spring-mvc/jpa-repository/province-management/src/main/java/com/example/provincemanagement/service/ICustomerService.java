package com.example.provincemanagement.service;

import com.example.provincemanagement.model.Customer;
import com.example.provincemanagement.model.Province;

public interface ICustomerService extends IGenerateService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
