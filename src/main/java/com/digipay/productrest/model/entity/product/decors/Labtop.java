package com.digipay.productrest.model.entity.product.decors;

import java.util.ArrayList;
import java.util.List;

public class Labtop implements Electronic {
    private String brand;
    private String model;
    private int randomAccessMemory;
    private String cpuModel;
    private double weight;
    private Electronic electronic;

    public Labtop(DigitalProducts digitalProducts) {
        this.electronic = digitalProducts;
    }
    @Override
    public List<String> getAllAttributes() {
        List<String> attributeList = new ArrayList<>(electronic.getAllAttributes());
        attributeList.add("brand");
        attributeList.add("model");
        attributeList.add("randomAccessMemory");
        attributeList.add("cpuModel");
        attributeList.add("weight");
        attributeList.add("type");
        return attributeList;
    }
}
