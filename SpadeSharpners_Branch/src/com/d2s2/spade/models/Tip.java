/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.models;

/**
 *
 * @author Heshan Sandamal
 */
public class Tip extends Item{
    private String size;
    private String country;
    private double price;

    public static final String TIP="Tip";
    
    public static final String SIZE="size";
    public static final String COUNTRY="country";
    public static final String PRICE="price";

    public Tip(String size, String country, double price) {
        this.size=size;
        this.country=country;
        this.price=price;
    }

    public Tip() {
    }
    
    
    
    
    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
