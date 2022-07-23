package com.factory;

import com.service.HeadphonesService;
import com.service.PhoneService;
import com.service.TelevisionSetService;
import com.service.impl.HeadphonesServiceImpl;
import com.service.impl.PhoneServiceImpl;
import com.service.impl.TelevisionSetServiceImpl;

public abstract class AbstractServiceFactory {

    private static HeadphonesService headphonesService;
    private static PhoneService phoneService;
    private static TelevisionSetService televisionSetService;

    public static HeadphonesService getHeadphonesService(){

        if (headphonesService == null){
            headphonesService = new HeadphonesServiceImpl();
        }
        return headphonesService;
    }

    public static PhoneService getPhoneService(){

        if (phoneService == null){
            phoneService = new PhoneServiceImpl();
        }
        return phoneService;
    }

    public static TelevisionSetService getTelevisionSetService(){

        if (televisionSetService == null){
            televisionSetService = new TelevisionSetServiceImpl();
        }
        return televisionSetService;
    }

}
