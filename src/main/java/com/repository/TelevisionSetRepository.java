package com.repository;

import com.model.TelevisionSetModelProduct;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TelevisionSetRepository implements CrudTelevisionSetRepository {

    private final List<TelevisionSetModelProduct> televisionsSet;

    public TelevisionSetRepository(){
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
            return false;
        }
        final TelevisionSetModelProduct originTelevisionSet = result.get();
        TelevisionSetCopy.copy(televisionSet, originTelevisionSet);
        return true;
    }

    @Override
    public boolean delete(String id) {
        final Iterator<TelevisionSetModelProduct> iterator = televisionsSet.iterator();
        while (iterator.hasNext()){
            final TelevisionSetModelProduct televisionSet = iterator.next();
            if (televisionSet.getId().equals(id)){
                iterator.remove();
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
