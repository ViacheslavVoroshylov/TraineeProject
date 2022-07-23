package com.factory;

import com.repository.HeadphonesRepository;
import com.repository.PhoneRepository;
import com.repository.TelevisionSetRepository;
import com.repository.impl.HeadphonesRepositoryImpl;
import com.repository.impl.PhoneRepositoryImpl;
import com.repository.impl.TelevisionSetRepositoryImpl;

public abstract class AbstractRepositoryFactory {

    private static HeadphonesRepository headphonesRepository;
    private static PhoneRepository phoneRepository;
    private static TelevisionSetRepository televisionSetRepository;

    public static HeadphonesRepository getHeadphonesRepository(){

        if (headphonesRepository == null){
            headphonesRepository = new HeadphonesRepositoryImpl();
        }
        return headphonesRepository;
    }

    public static PhoneRepository getPhoneRepository(){

        if (phoneRepository == null){
            phoneRepository = new PhoneRepositoryImpl();
        }
        return phoneRepository;
    }

    public static TelevisionSetRepository getTelevisionSetRepository(){

        if (televisionSetRepository == null){
            televisionSetRepository = new TelevisionSetRepositoryImpl();
        }
        return televisionSetRepository;
    }

}
