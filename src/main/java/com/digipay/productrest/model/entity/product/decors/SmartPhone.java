package com.digipay.productrest.model.entity.product.decors;

import java.util.ArrayList;
import java.util.List;

public class SmartPhone implements Electronic {
    private String brand;
    private String model;
    private Double weight;
    private Double width;
    private Double height;
    private Electronic electronic;

    public SmartPhone(DigitalProducts digitalProducts){
        this.electronic = electronic;
    }

    @Override
    public List<String> getAllAttributes() {
        List<String> attributeList = new ArrayList<>(electronic.getAllAttributes());
        attributeList.add("brand");
        attributeList.add("model");
        attributeList.add("weight");
        attributeList.add("width");
        attributeList.add("height");
        return attributeList;
    }
}
