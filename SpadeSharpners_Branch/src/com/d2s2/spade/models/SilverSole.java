/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.models;

/**
 *
 * @author Heshan Sandamal
 */
public class SilverSole extends Item{
    private String type;
    private double price;
    
    public static final String SILVERSOLE="Silver Sole";
    public static final String TYPE="type";
    public static final String PRICE="price";

    public SilverSole(String type, double price) {
        this.type=type;
        this.price=price;
    }

    public SilverSole() {
    }
    
    
    

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
