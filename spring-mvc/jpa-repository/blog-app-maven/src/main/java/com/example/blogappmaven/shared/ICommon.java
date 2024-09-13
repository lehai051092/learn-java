package com.example.blogappmaven.shared;

public interface ICommon<T> {
    T findById(Long id);

    void save(T t);

    void update(Long id, T t);

    void delete(Long id);
}
