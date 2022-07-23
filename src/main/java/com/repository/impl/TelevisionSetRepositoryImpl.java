package com.repository.impl;

import com.model.TelevisionSetModelProduct;
import org.apache.log4j.Logger;

import java.util.*;

public class TelevisionSetRepositoryImpl implements com.repository.TelevisionSetRepository {

    private static final Logger LOGGER = Logger.getLogger(TelevisionSetRepositoryImpl.class);

    private final List<TelevisionSetModelProduct> televisionsSet;

    public TelevisionSetRepositoryImpl(){
        televisionsSet = new LinkedList<>();
    }

    @Override
    public void save(TelevisionSetModelProduct televisionSet) {
        televisionsSet.add(televisionSet);
    }

    @Override
    public void saveAll(List<TelevisionSetModelProduct> televisionsSet) {
        for (TelevisionSetModelProduct televisionSet : televisionsSet){
            save(televisionSet);
        }
    }

    @Override
    public boolean update(TelevisionSetModelProduct televisionSet) {
        final Optional<TelevisionSetModelProduct> result = findById(televisionSet.getId());
        if(result.isEmpty()) {
            LOGGER.info("Element is not found");
            return false;
        }
        final TelevisionSetModelProduct originTelevisionSet = result.get();
        TelevisionSetCopy.copy(televisionSet, originTelevisionSet);
        LOGGER.info("Element is update");
        return true;
    }

    @Override
    public boolean delete(String id) {
        final Iterator<TelevisionSetModelProduct> iterator = televisionsSet.iterator();
        while (iterator.hasNext()){
            final TelevisionSetModelProduct televisionSet = iterator.next();
            if (televisionSet.getId().equals(id)){
                iterator.remove();
                LOGGER.info("Delete item " + id + " was successful");
                return true;
            }
        }
        return false;
    }

    @Override
    public List<TelevisionSetModelProduct> getAll() {
        if (televisionsSet.isEmpty()){
            return Collections.emptyList();
        }
        return televisionsSet;
    }

    @Override
    public Optional<TelevisionSetModelProduct> findById(String id) {
        TelevisionSetModelProduct result = null;
        for (TelevisionSetModelProduct televisionSet : televisionsSet){
            if (televisionSet.getId().equals(id)){
                result = televisionSet;
            }
        }
        return Optional.ofNullable(result);
    }

    private static class TelevisionSetCopy {
        private static void copy(final TelevisionSetModelProduct from, final TelevisionSetModelProduct to) {
            to.setCount(from.getCount());
            to.setPrice(from.getPrice());
            to.setTitle(from.getTitle());
        }
    }
}
