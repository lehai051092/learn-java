package com.example.blogappmaven.shared;

import java.util.Optional;

public interface ICommon<T> {
    Iterable<T> findAll();

    T findById(Long id);

    void save(T t);

    void update(Long id, T t);

    void delete(Long id);
}
