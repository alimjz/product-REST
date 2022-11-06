package com.digipay.productrest.model.entity.product.decors;

import java.util.ArrayList;
import java.util.List;

public class DigitalProducts implements Electronic {

    private String type;
    private String madeInCountry;

    private Electronic electronic;

    public DigitalProducts(Electronic electronic) {
        this.electronic = electronic;
    }

    @Override
    public List<String> getAllAttributes() {
        List<String> attributeList = new ArrayList<>();
        attributeList.add("type");
        attributeList.add("madeInCountry");
        return attributeList;
    }
}
