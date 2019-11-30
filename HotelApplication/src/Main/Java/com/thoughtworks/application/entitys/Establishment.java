package com.thoughtworks.application.entitys;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public abstract class Hotel {

    private String name;
    private String location;
    private int classification;
    private Map<String, BigDecimal> prices = new HashMap<String, BigDecimal>();
    private Map<String, BigDecimal> memberPrices = new HashMap<String, BigDecimal>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public Map<String, BigDecimal> getPrices() {
        return prices;
    }

    public void setPrices(String key, BigDecimal price) {
        this.prices.put(key, price);
    }

    public Map<String, BigDecimal> getMemberPrices() {
        return memberPrices;
    }

    public void setMemberPrices(String key, BigDecimal price) {
        this.memberPrices.put(key, price);

    }
}
