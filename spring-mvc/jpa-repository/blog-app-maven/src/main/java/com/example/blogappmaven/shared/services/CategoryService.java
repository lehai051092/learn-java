package com.example.blogappmaven.shared.services;

import com.example.blogappmaven.model.Category;
import com.example.blogappmaven.repository.ICategoryRepository;
import com.example.blogappmaven.shared.interfaces.ICategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    @Autowired
    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(Long id, Category category) {
        findById(id);
        categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        categoryRepository.deleteById(id);
    }
}
