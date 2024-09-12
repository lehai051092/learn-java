package com.example.provincemanagement.repository;

import com.example.provincemanagement.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProvinceRepository extends JpaRepository<Province, Long> {
}
