package com.service.impl;

import com.factory.AbstractRepositoryFactory;
import com.model.Manufacturer;
import com.model.PhoneModelProduct;
import com.repository.PhoneRepository;
import com.repository.impl.PhoneRepositoryImpl;
import com.service.PhoneService;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class PhoneServiceImpl implements PhoneService {

    private List<PhoneModelProduct> phonesList;
    private static final Random RANDOM = new Random();
    private static final PhoneRepository PHONE_REPOSITORY = AbstractRepositoryFactory.getPhoneRepository();
    private static final Logger LOGGER = Logger.getLogger(PhoneServiceImpl.class);

    @Override
    public void createAndSaveProduct(Integer count) {
        List<PhoneModelProduct> phones = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            phones.add(new PhoneModelProduct(
                    "Title-" + RANDOM.nextInt(1000),
                    RANDOM.nextInt(500),
                    Math.random() * 500,
                    "Model-" + RANDOM.nextInt(10),
                    Manufacturer.getRandomManufacturer()
            ));
        }

        PHONE_REPOSITORY.saveAll(phones);
        phonesList = phones;
    }

    @Override
    public String getIdProductByNumberList(Integer numberListElement){
        return phonesList.get(numberListElement).getId();
   }

   @Override
    public void changeCountProductByNumberListElement(Integer numberListElement, Integer countProduct){
        phonesList.get(numberListElement).setCount(countProduct);
        LOGGER.info("Number element " + numberListElement + " on the list phone count change to " + countProduct);
    }

    @Override
    public boolean removeProduct(String id){
        PHONE_REPOSITORY.delete(id);
        return true;
    }

    @Override
    public void printAll() {
        for (PhoneModelProduct phone : PHONE_REPOSITORY.getAll()) {
            System.out.println(phone);
        }
    }
}