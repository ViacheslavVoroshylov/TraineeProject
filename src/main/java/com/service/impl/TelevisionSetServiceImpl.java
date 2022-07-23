package com.service.impl;

import com.factory.AbstractRepositoryFactory;
import com.model.Manufacturer;
import com.model.TelevisionSetModelProduct;
import com.repository.PhoneRepository;
import com.repository.TelevisionSetRepository;
import com.repository.impl.PhoneRepositoryImpl;
import com.repository.impl.TelevisionSetRepositoryImpl;
import com.service.TelevisionSetService;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TelevisionSetServiceImpl implements TelevisionSetService {

    private List<TelevisionSetModelProduct> televisionSetList;
    private static final Random RANDOM = new Random();
    private static final TelevisionSetRepository TELEVISION_SET_REPOSITORY = AbstractRepositoryFactory.getTelevisionSetRepository();
    private static final Logger LOGGER = Logger.getLogger(TelevisionSetServiceImpl.class);

    @Override
    public void createAndSaveProduct(Integer count) {
        List<TelevisionSetModelProduct> televisionSet = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            televisionSet.add(new TelevisionSetModelProduct(
                    "Title-" + RANDOM.nextInt(1000),
                    RANDOM.nextInt(500),
                    Math.random() * 500,
                    "Model-" + RANDOM.nextInt(10),
                    Manufacturer.getRandomManufacturer()
            ));
        }

        TELEVISION_SET_REPOSITORY.saveAll(televisionSet);
        televisionSetList = televisionSet;
    }

    @Override
    public String getIdProductByNumberList(Integer numberListElement){
        return televisionSetList.get(numberListElement).getId();
    }

    @Override
    public void changeCountProductByNumberListElement(Integer numberListElement, Integer countTelevisionSet){
        televisionSetList.get(numberListElement).setCount(countTelevisionSet);
        LOGGER.info("Number element " + numberListElement + " on the list television set count change to " + countTelevisionSet);
    }

    @Override
    public boolean removeProduct(String id){
        TELEVISION_SET_REPOSITORY.delete(id);
        return true;
    }

    @Override
    public void printAll() {
        for (TelevisionSetModelProduct televisionSet : TELEVISION_SET_REPOSITORY.getAll()) {
            System.out.println(televisionSet);
        }
    }
}