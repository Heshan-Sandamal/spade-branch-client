/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.models;

/**
 *
 * @author Heshan Sandamal
 */
public class Brand {
    private String brandId;
    private String brand;
    
    public static final String BRANDID="brandId";;
    public static final String BRAND="brand";
    
 
   

    public Brand(String brandId, String brand) {
        this.brandId=brandId;
        this.brand=brand;
    }

    public Brand() {
        
    }

    /**
     * @return the brandId
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * @param brandId the brandId to set
     */
    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        String brandId = (String) obj;
        if (this.getBrandId().equals(brandId)) {
            return true;
        } else {
            return false;
        }
    }
    
}
