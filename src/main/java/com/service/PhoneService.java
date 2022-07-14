package com.service;


import com.model.Manufacturer;
import com.model.PhoneModelProduct;
import com.repository.PhoneRepository;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class PhoneService {

    private static final Logger LOGGER = Logger.getLogger(PhoneService.class);

    private static final Random RANDOM = new Random();
    private static final PhoneRepository REPOSITORY = new PhoneRepository();

    public List<PhoneModelProduct> createAndSavePhones(int count) {
        List<PhoneModelProduct> phones = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            phones.add(new PhoneModelProduct(
                    "Title-" + RANDOM.nextInt(1000),
                    RANDOM.nextInt(500),
                    Math.random() * 500,
                    "Model-" + RANDOM.nextInt(10),
                    getRandomManufacturer()
            ));
        }
        REPOSITORY.saveAll(phones);
        return phones;
    }

    public String createSaveAndGetIdPhones(int count, int numberListElement){
        return createAndSavePhones(count).get(numberListElement).getId();
    }

    public void createSaveAndSetCountPhones(int countElementsList, int numberListElement, int countPhones){
        createAndSavePhones(countElementsList).get(numberListElement).setCount(countPhones);
        LOGGER.info("Phone count change");
    }

    public boolean removePhones(String id){
        REPOSITORY.delete(id);
        return true;
    }

    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }

    public void printAll() {
        for (PhoneModelProduct phone : REPOSITORY.getAll()) {
            System.out.println(phone);
        }
    }
}