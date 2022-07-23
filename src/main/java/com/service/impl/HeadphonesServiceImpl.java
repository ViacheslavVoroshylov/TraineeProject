package com.service.impl;

import com.model.HeadphonesModelProduct;
import com.model.Manufacturer;
import com.repository.HeadphonesRepository;
import com.repository.impl.HeadphonesRepositoryImpl;
import com.service.HeadphonesService;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class HeadphonesServiceImpl implements HeadphonesService {

    private List<HeadphonesModelProduct> headphonesList;
    private static final Random RANDOM = new Random();
    private static final HeadphonesRepository HEADPHONES_REPOSITORY = new HeadphonesRepositoryImpl();
    private static final Logger LOGGER = Logger.getLogger(HeadphonesServiceImpl.class);

    @Override
    public void createAndSaveProduct(Integer count) {
        List<HeadphonesModelProduct> headphones = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            headphones.add(new HeadphonesModelProduct(
                    "Title-" + RANDOM.nextInt(1000),
                    RANDOM.nextInt(500),
                    Math.random() * 500,
                    "Model-" + RANDOM.nextInt(10),
                    Manufacturer.getRandomManufacturer()
            ));
        }

        HEADPHONES_REPOSITORY.saveAll(headphones);
        headphonesList = headphones;
    }

    @Override
    public String getIdProductByNumberList(Integer numberListElement){
        return headphonesList.get(numberListElement).getId();
    }

    @Override
    public void changeCountProductByNumberListElement(Integer numberListElement, Integer countHeadphones){
        headphonesList.get(numberListElement).setCount(countHeadphones);
        LOGGER.info("Number element " + numberListElement + " on the list headphones count change to " + countHeadphones);
    }

    @Override
    public boolean removeProduct(String id){
        HEADPHONES_REPOSITORY.delete(id);
        return true;
    }

    @Override
    public void printAll() {
        for (HeadphonesModelProduct headphones : HEADPHONES_REPOSITORY.getAll()) {
            System.out.println(headphones);
        }
    }
}