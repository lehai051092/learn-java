package com.example.springcustomermanagementrestful.api;

import java.util.Optional;

public interface IGeneralService<E> {
    Iterable<E> findAll();

    Optional<E> findById(Long id);

    E save(E entity);

    void remove(Long id);
}
