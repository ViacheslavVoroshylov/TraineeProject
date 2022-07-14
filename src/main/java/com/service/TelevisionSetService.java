package com.service;

import com.model.Manufacturer;
import com.model.PhoneModelProduct;
import com.model.TelevisionSetModelProduct;
import com.repository.TelevisionSetRepository;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TelevisionSetService {

    private static final Logger LOGGER = Logger.getLogger(TelevisionSetService.class);

    private static final Random RANDOM = new Random();

    private static final TelevisionSetRepository REPOSITORY = new TelevisionSetRepository();

    public List<TelevisionSetModelProduct> createAndSaveTelevisionSet(int count) {
        List<TelevisionSetModelProduct> televisionSet = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            televisionSet.add(new TelevisionSetModelProduct(
                    "Title-" + RANDOM.nextInt(1000),
                    RANDOM.nextInt(500),
                    Math.random() * 500,
                    "Model-" + RANDOM.nextInt(10),
                    getRandomManufacturer()
            ));
        }
        REPOSITORY.saveAll(televisionSet);
        return televisionSet;
    }

    public String createSaveAndGetIdTelevisionSet(int count, int numberListElement){
        return createAndSaveTelevisionSet(count).get(numberListElement).getId();
    }

    public void createSaveAndSetCountTelevisionSet(int countElementsList, int numberListElement, int countTelevisionSet){
        createAndSaveTelevisionSet(countElementsList).get(numberListElement).setCount(countTelevisionSet);
        LOGGER.info("Television Set count change");
    }

    public boolean removeTelevisionSet(String id){
        REPOSITORY.delete(id);
        return true;
    }

    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }

    public void printAll() {
        for (TelevisionSetModelProduct televisionSet : REPOSITORY.getAll()) {
            System.out.println(televisionSet);
        }
    }
}