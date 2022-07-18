package com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelevisionSetModelProduct extends Product{

    private final String model;

    public TelevisionSetModelProduct(String title, int count, double price, String model, Manufacturer manufacturer) {
        super(title, count, price, manufacturer);
        this.model = model;
    }

    @Override
    public String toString() {
        return "TV{" +
                "manufacturer=" + manufacturer +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}