package com.repository;

import com.model.PhoneModelProduct;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PhoneRepository implements CrudPhoneRepository {

    private final List<PhoneModelProduct> phones;

    public PhoneRepository() {
        phones = new LinkedList<>();
    }

    @Override
    public void save(PhoneModelProduct phone) {
        phones.add(phone);
    }

    @Override
    public void saveAll(List<PhoneModelProduct> phones) {
        for (PhoneModelProduct phone : phones) {
            save(phone);
        }
    }

    @Override
    public boolean update(PhoneModelProduct phone) {
        final Optional<PhoneModelProduct> result = findById(phone.getId());
        if (result.isEmpty()) {
            return false;
        }
        final PhoneModelProduct originPhone = result.get();
        PhoneCopy.copy(phone, originPhone);
        return true;
    }

    @Override
    public boolean delete(String id) {
        final Iterator<PhoneModelProduct> iterator = phones.iterator();
        while (iterator.hasNext()) {
            final PhoneModelProduct phone = iterator.next();
            if (phone.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<PhoneModelProduct> getAll() {
        if (phones.isEmpty()) {
            return Collections.emptyList();
        }
        return phones;
    }

    @Override
    public Optional<PhoneModelProduct> findById(String id) {
        PhoneModelProduct result = null;
        for (PhoneModelProduct phone : phones) {
            if (phone.getId().equals(id)) {
                result = phone;
            }
        }
        return Optional.ofNullable(result);
    }

    private static class PhoneCopy {
        private static void copy(final PhoneModelProduct from, final PhoneModelProduct to) {
            to.setCount(from.getCount());
            to.setPrice(from.getPrice());
            to.setTitle(from.getTitle());
        }
    }
}