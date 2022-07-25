package com.model;

import java.util.Random;

public enum Manufacturer {
    SAMSUNG,
    XIAOMI,
    HUAWEI,
    SONY;

    private static final Random RANDOM = new Random();

    public static Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = values();
        return values[RANDOM.nextInt(values().length)];
    }
}
