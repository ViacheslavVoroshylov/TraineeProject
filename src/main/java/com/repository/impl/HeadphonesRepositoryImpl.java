package com.repository.impl;

import com.model.HeadphonesModelProduct;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


public class HeadphonesRepositoryImpl implements com.repository.HeadphonesRepository {

    private static final Logger LOGGER = Logger.getLogger(HeadphonesRepositoryImpl.class);
    private final List<HeadphonesModelProduct> headphones;

    public HeadphonesRepositoryImpl() {
        headphones = new LinkedList<>();
    }

    @Override
    public void save(HeadphonesModelProduct headphone) {
        headphones.add(headphone);
    }

    @Override
    public void saveAll(List<HeadphonesModelProduct> headphones) {
        for (HeadphonesModelProduct headphone : headphones) {
            save(headphone);
        }
    }

    @Override
    public boolean update(HeadphonesModelProduct headphone) {
        final Optional<HeadphonesModelProduct> result = findById(headphone.getId());
        if (result.isEmpty()) {
            LOGGER.info("Element is not found");
            return false;
        }
        final HeadphonesModelProduct originHeadphones = result.get();
        HeadphonesCopy.copy(headphone, originHeadphones);
        LOGGER.info("Element is update");
        return true;
    }

    @Override
    public boolean delete(String id) {
        final Iterator<HeadphonesModelProduct> iterator = headphones.iterator();
        while (iterator.hasNext()) {
            final HeadphonesModelProduct headphone = iterator.next();
            if (headphone.getId().equals(id)) {
                iterator.remove();
                LOGGER.info("Delete item " + id + " was successful");
                return true;
            }
        }
        return false;
    }

    @Override
    public List<HeadphonesModelProduct> getAll() {
        if (headphones.isEmpty()) {
            return Collections.emptyList();
        }
        return headphones;
    }

    @Override
    public Optional<HeadphonesModelProduct> findById(String id) {
        HeadphonesModelProduct result = null;
        for (HeadphonesModelProduct headphone : headphones) {
            if (headphone.getId().equals(id)) {
                result = headphone;
            }
        }
        return Optional.ofNullable(result);
    }

    private static class HeadphonesCopy {
        private static void copy(final HeadphonesModelProduct from, final HeadphonesModelProduct to) {
            to.setCount(from.getCount());
            to.setPrice(from.getPrice());
            to.setTitle(from.getTitle());
        }
    }
}