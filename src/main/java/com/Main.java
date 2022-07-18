package com;

import com.service.HeadphonesService;
import com.service.PhoneService;
import com.service.TelevisionSetService;

public class Main {

    private static final PhoneService PHONE_SERVICE = new PhoneService();

    private static final HeadphonesService HEADPHONES_SERVICE = new HeadphonesService();

    private static final TelevisionSetService TELEVISION_SET_SERVICE = new TelevisionSetService();

    public static void main(String[] args) {


        PHONE_SERVICE.createAndSavePhones(3);
        PHONE_SERVICE.printAll();
        PHONE_SERVICE.removePhones(PHONE_SERVICE.getIdPhonesByNumberList(1));
        PHONE_SERVICE.printAll();

        PHONE_SERVICE.changeCountPhonesByNumberListElement(0,2);
        PHONE_SERVICE.printAll();

        HEADPHONES_SERVICE.createAndSaveHeadphones(2);
        HEADPHONES_SERVICE.printAll();

        TELEVISION_SET_SERVICE.createAndSaveTelevisionSet(2);
        TELEVISION_SET_SERVICE.printAll();
    }
}
