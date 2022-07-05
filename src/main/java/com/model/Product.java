package com.model;

import java.util.UUID;

public abstract class Product {
    protected String id;
    protected String title;
    protected int count;
    protected double price;

    public Product(String title, int count, double price) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.count = count;
        this.price = price;
    }
}
