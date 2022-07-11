package com.service;

import com.model.Manufacturer;
import com.model.TelevisionSetModelProduct;
import com.repository.TelevisionSetRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TelevisionSetService {

    private static final Random RANDOM = new Random();
    private static final TelevisionSetRepository REPOSITORY = new TelevisionSetRepository();

    public void createAndSavePhones(int count) {
        List<TelevisionSetModelProduct> televisionSet = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            televisionSet.add(new TelevisionSetModelProduct(
                    "Title-" + RANDOM.nextInt(1000),
                    RANDOM.nextInt(500),
                    RANDOM.nextDouble(),
                    "Model-" + RANDOM.nextInt(10),
                    getRandomManufacturer()
            ));
        }
        REPOSITORY.saveAll(televisionSet);
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
