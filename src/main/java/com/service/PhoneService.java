package com.service;

import com.model.Manufacturer;
import com.model.PhoneModelProduct;
import com.repository.PhoneRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

public class PhoneService {

    private List<PhoneModelProduct> phonesList;
    private static final Random RANDOM = new Random();
    private static final PhoneRepository REPOSITORY = new PhoneRepository();
    private static final Logger LOGGER = Logger.getLogger(PhoneService.class);

    public void createAndSavePhones(int count) {
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
        phonesList = phones;
    }

    public String getIdPhonesByNumberList(int numberListElement){
        return phonesList.get(numberListElement).getId();
   }

    public void changeCountPhonesByNumberListElement(int numberListElement, int countPhones){
        phonesList.get(numberListElement).setCount(countPhones);
        LOGGER.info("Number element " + numberListElement + " on the list phone count change to " + countPhones);
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