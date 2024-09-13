package com.example.blogappmaven.shared.interfaces;

import com.example.blogappmaven.model.Category;
import com.example.blogappmaven.shared.ICommon;

import java.util.List;

public interface ICategoryService extends ICommon<Category> {
    List<Category> findAll();
}
