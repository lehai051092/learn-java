package com.example.provincemanagement.repository;

import com.example.provincemanagement.model.Province;
import org.springframework.data.repository.CrudRepository;

public interface IProvinceRepository extends CrudRepository<Province, Long> {
}
