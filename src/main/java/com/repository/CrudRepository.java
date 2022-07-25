package com.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {

    void save(T phone);

    void saveAll(List<T> phones);

    boolean update(T phone);

    boolean delete(ID id);

    List<T> getAll();

    Optional<T> findById(ID id);

}
