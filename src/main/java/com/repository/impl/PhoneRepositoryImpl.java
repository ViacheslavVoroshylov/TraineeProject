package com.repository.impl;

import com.model.PhoneModelProduct;
import org.apache.log4j.Logger;

import java.util.*;

public class PhoneRepositoryImpl implements com.repository.PhoneRepository {

    private static final Logger LOGGER = Logger.getLogger(PhoneRepositoryImpl.class);

    private final List<PhoneModelProduct> phones;

    public PhoneRepositoryImpl() {
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
            LOGGER.info("Element is not found");
            return false;
        }
        final PhoneModelProduct originPhone = result.get();
        PhoneCopy.copy(phone, originPhone);
        LOGGER.info("Element is update");
        return true;
    }

    @Override
    public boolean delete(String id) {
        final Iterator<PhoneModelProduct> iterator = phones.iterator();
        while (iterator.hasNext()) {
            final PhoneModelProduct phone = iterator.next();
            if (phone.getId().equals(id)) {
                iterator.remove();
                LOGGER.info("Delete item " + id + " was successful");
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