package com.service;

import com.model.Manufacturer;
import com.model.PhoneModelProduct;
import com.repository.PhoneRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PhoneService {
    private static final Random RANDOM = new Random();
    private static final PhoneRepository REPOSITORY = new PhoneRepository();

    public void createAndSavePhones(int count) {
        List<PhoneModelProduct> phones = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            phones.add(new PhoneModelProduct(
                    "Title-" + RANDOM.nextInt(1000),
                    RANDOM.nextInt(500),
                    RANDOM.nextDouble(),
                    "Model-" + RANDOM.nextInt(10),
                    getRandomManufacturer()
            ));
        }
        REPOSITORY.saveAll(phones);
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