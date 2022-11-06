package com.digipay.productrest.model.entity.product.decors;

import java.util.ArrayList;
import java.util.List;

public class SmartWatch implements Electronic{
    private Double height;
    private Double width;
    private Double weight;
    private String brand;
    private String model;
    private Electronic electronic;

    public SmartWatch(DigitalProducts digitalProducts){
        this.electronic = digitalProducts;
    }


    @Override
    public List<String> getAllAttributes() {
        List<String> attributeList = new ArrayList<>(electronic.getAllAttributes());
        attributeList.add("height");
        attributeList.add("width");
        attributeList.add("weight");
        attributeList.add("brand");
        attributeList.add("model");
        return attributeList;
    }
}
