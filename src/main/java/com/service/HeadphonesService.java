package com.service;

import com.model.Manufacturer;
import com.model.HeadphonesModelProduct;
import com.repository.HeadphonesRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class HeadphonesService {
    private static final Random RANDOM = new Random();
    private static final HeadphonesRepository REPOSITORY = new HeadphonesRepository();

    public void createAndSavePhones(int count) {
        List<HeadphonesModelProduct> headphones = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            headphones.add(new HeadphonesModelProduct(
                    "Title-" + RANDOM.nextInt(1000),
                    RANDOM.nextInt(500),
                    RANDOM.nextDouble(),
                    "Model-" + RANDOM.nextInt(10),
                    getRandomManufacturer()
            ));
        }
        REPOSITORY.saveAll(headphones);
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
