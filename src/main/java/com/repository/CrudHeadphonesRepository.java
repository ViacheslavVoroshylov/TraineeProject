package com.repository;

import com.model.HeadphonesModelProduct;

import java.util.List;
import java.util.Optional;

public interface CrudHeadphonesRepository {

    void save(HeadphonesModelProduct headphones);

    void saveAll(List<HeadphonesModelProduct> headphones);

    boolean update(HeadphonesModelProduct headphones);

    boolean delete(String id);

    List<HeadphonesModelProduct> getAll();

    Optional<HeadphonesModelProduct> findById(String id);

}
