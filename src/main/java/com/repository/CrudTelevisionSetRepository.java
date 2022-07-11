package com.repository;

import com.model.TelevisionSetModelProduct;

import java.util.List;
import java.util.Optional;

public interface CrudTelevisionSetRepository {

    void save(TelevisionSetModelProduct televisionSet);

    void saveAll(List<TelevisionSetModelProduct> televisionsSet);

    boolean update(TelevisionSetModelProduct televisionSet);

    boolean delete(String id);

    List<TelevisionSetModelProduct> getAll();

    Optional<TelevisionSetModelProduct> findById(String id);
}
