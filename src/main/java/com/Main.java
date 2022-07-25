package com;

import com.factory.AbstractServiceFactory;
import com.service.HeadphonesService;
import com.service.PhoneService;
import com.service.TelevisionSetService;

public class Main {

    private static final PhoneService PHONE_SERVICE = AbstractServiceFactory.getPhoneService();
    private static final HeadphonesService HEADPHONES_SERVICE = AbstractServiceFactory.getHeadphonesService();
    private static final TelevisionSetService TELEVISION_SET_SERVICE = AbstractServiceFactory.getTelevisionSetService();

    public static void main(String[] args) {


        PHONE_SERVICE.createAndSaveProduct(3);
        PHONE_SERVICE.printAll();
        PHONE_SERVICE.removeProduct(PHONE_SERVICE.getIdProductByNumberList(1));
        PHONE_SERVICE.printAll();

        PHONE_SERVICE.changeCountProductByNumberListElement(0,2);
        PHONE_SERVICE.printAll();

        HEADPHONES_SERVICE.createAndSaveProduct(2);
        HEADPHONES_SERVICE.printAll();

        TELEVISION_SET_SERVICE.createAndSaveProduct(2);
        TELEVISION_SET_SERVICE.printAll();
    }
}
