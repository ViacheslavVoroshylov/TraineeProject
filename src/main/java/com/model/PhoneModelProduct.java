package com.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
@Setter
public class PhoneModelProduct extends Product {
    private final String model;

    public PhoneModelProduct(String title, int count, double price, String model, Manufacturer manufacturer) {
        super(title, count, price, manufacturer);
        this.model = model;
    }

    @Override
    public String toString() {
        String[] elements = {
                "Phone{" +
                        "manufacturer=" + manufacturer +
                        ", id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", count=" + count +
                        ", price=" + price +
                        '}'
        };

        return StringUtils.join(Arrays.asList(elements), null);
    }
}