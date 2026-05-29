package com.fashionstore.model;

public class Brand {

    private int brandId;

    private String brandName;

    private int categoryId;

    
    public Brand() {

    }

    
    public Brand(int brandId, String brandName, int categoryId) {

        this.brandId = brandId;
        this.brandName = brandName;
        this.categoryId = categoryId;
    }

    
    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}