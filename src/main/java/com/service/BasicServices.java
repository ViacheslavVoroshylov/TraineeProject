package com.service;

public interface BasicServices<COUNT, NUMBER_LIST_ELEMENT, COUNT_PRODUCT, ID> {

    void createAndSaveProduct(COUNT count);

    String getIdProductByNumberList(NUMBER_LIST_ELEMENT numberListElement);

    void changeCountProductByNumberListElement(NUMBER_LIST_ELEMENT numberListElement, COUNT_PRODUCT countProduct);

    boolean removeProduct(ID id);

    void printAll();
}
