package com.example.provincemanagement.service.Impl;

import com.example.provincemanagement.model.Province;
import com.example.provincemanagement.repository.IProvinceRepository;
import com.example.provincemanagement.service.interfaces.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
    private final IProvinceRepository provinceRepository;

    @Autowired
    public ProvinceService(IProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
