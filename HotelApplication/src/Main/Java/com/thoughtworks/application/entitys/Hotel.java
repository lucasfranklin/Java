package com.thoughtworks.application.entitys;

import java.util.List;

public class Hotel extends Establishment {

    public Hotel(Long identification, String name, String location, int classification, List<Prices> listPrices) {
        super(identification, name, location, classification, listPrices);
    }
}

