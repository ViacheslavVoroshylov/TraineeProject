package com.service;

import com.model.Manufacturer;
import com.model.HeadphonesModelProduct;
import com.model.PhoneModelProduct;
import com.repository.HeadphonesRepository;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class HeadphonesService {

    private static final Logger LOGGER = Logger.getLogger(HeadphonesService.class);

    private static final Random RANDOM = new Random();

    private static final HeadphonesRepository REPOSITORY = new HeadphonesRepository();

    public List<HeadphonesModelProduct> createAndSaveHeadphones(int count) {
        List<HeadphonesModelProduct> headphones = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            headphones.add(new HeadphonesModelProduct(
                    "Title-" + RANDOM.nextInt(1000),
                    RANDOM.nextInt(500),
                    Math.random() * 500,
                    "Model-" + RANDOM.nextInt(10),
                    getRandomManufacturer()
            ));
        }
        REPOSITORY.saveAll(headphones);
        return headphones;
    }

    public String createSaveAndGetIdHeadphones(int count, int numberListElement){
        return createAndSaveHeadphones(count).get(numberListElement).getId();
    }

    public void createSaveAndSetCountHeadphones(int countElementsList, int numberListElement, int countHeadphones){
        createAndSaveHeadphones(countElementsList).get(numberListElement).setCount(countHeadphones);
        LOGGER.info("Headphones count change");
    }

    public boolean removeHeadphones(String id){
        REPOSITORY.delete(id);
        return true;
    }

    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }

    public void printAll() {
        for (HeadphonesModelProduct headphones : REPOSITORY.getAll()) {
            System.out.println(headphones);
        }
    }
}