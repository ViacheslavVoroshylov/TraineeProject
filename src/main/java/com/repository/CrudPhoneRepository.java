package com.repository;

import com.model.PhoneModelProduct;

import java.util.List;
import java.util.Optional;

public interface CrudPhoneRepository {
    void save(PhoneModelProduct phone);

    void saveAll(List<PhoneModelProduct> phones);

    boolean update(PhoneModelProduct phone);

    boolean delete(String id);

    List<PhoneModelProduct> getAll();

    Optional<PhoneModelProduct> findById(String id);
}