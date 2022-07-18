package com.service;

import com.model.Manufacturer;
import com.model.HeadphonesModelProduct;
import com.repository.HeadphonesRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

public class HeadphonesService {

    private List<HeadphonesModelProduct> headphonesList;
    private static final Random RANDOM = new Random();
    private static final HeadphonesRepository REPOSITORY = new HeadphonesRepository();
    private static final Logger LOGGER = Logger.getLogger(HeadphonesService.class);

    public void createAndSaveHeadphones(int count) {
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
        headphonesList = headphones;
    }

    public String getIdHeadphonesByNumberList(int numberListElement){
        return headphonesList.get(numberListElement).getId();
    }

    public void changeCountHeadphonesByNumberListElement(int numberListElement, int countHeadphones){
        headphonesList.get(numberListElement).setCount(countHeadphones);
        LOGGER.info("Number element " + numberListElement + " on the list headphones count change to " + countHeadphones);
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