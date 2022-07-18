package com.service;

import com.model.Manufacturer;
import com.model.TelevisionSetModelProduct;
import com.repository.TelevisionSetRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

public class TelevisionSetService {

    private List<TelevisionSetModelProduct> televisionSetList;
    private static final Random RANDOM = new Random();
    private static final TelevisionSetRepository REPOSITORY = new TelevisionSetRepository();
    private static final Logger LOGGER = Logger.getLogger(TelevisionSetService.class);

    public void createAndSaveTelevisionSet(int count) {
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
        televisionSetList = televisionSet;
    }

    public String createSaveAndGetIdTelevisionSet(int numberListElement){
        return televisionSetList.get(numberListElement).getId();
    }

    public boolean removeTelevisionSet(String id){
        REPOSITORY.delete(id);
        return true;
    }

    public void changeCountTelevisionSetByNumberListElement(int numberListElement, int countTelevisionSet){
        televisionSetList.get(numberListElement).setCount(countTelevisionSet);
        LOGGER.info("Number element " + numberListElement + " on the list television set count change to " + countTelevisionSet);
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