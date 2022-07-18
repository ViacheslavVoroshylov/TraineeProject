package com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeadphonesModelProduct extends Product{

    private final String model;

    public HeadphonesModelProduct(String title, int count, double price, String model, Manufacturer manufacturer) {
        super(title, count, price, manufacturer);
        this.model = model;
    }

    @Override
    public String toString() {
        return "Headphones{" +
                "manufacturer=" + manufacturer +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}