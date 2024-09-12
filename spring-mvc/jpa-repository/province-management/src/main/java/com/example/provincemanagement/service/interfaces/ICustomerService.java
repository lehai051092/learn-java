package com.example.provincemanagement.service.interfaces;

import com.example.provincemanagement.model.Customer;
import com.example.provincemanagement.model.Province;
import com.example.provincemanagement.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGenerateService<Customer> {
    Page<Customer> findAll(Pageable pageable);

    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(Pageable pageable, String name);
}
