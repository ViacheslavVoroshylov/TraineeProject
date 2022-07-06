package com.model;

import lombok.Getter;

@Getter
public class Phone extends Product{

    private final String model;
    private final Manufacturer manufacturer;

    public Phone(String title, int count, double price, String model, Manufacturer manufacturer) {
        super(title, count, price);
        this.model = model;
        this.manufacturer = manufacturer;
    }
}
