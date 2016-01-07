/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.models;

/**
 *
 * @author Heshan Sandamal
 */
public class Wheel extends Item {

    private String size;
    private String country;
    private double diameter;
    private double hole;
    
    public static final String WHEEL = "Wheel";
    
    public static final String SIZE = "size";
    public static final String COUNTRY = "country";
    public static final String DIAMETER = "diameter";
    public static final String HOLE = "hole";

    public Wheel(String size, String country, double diamter, double hole) {
        this.size=size;
        this.country=country;
        this.diameter=diamter;
        this.hole=hole;
    }

    public Wheel() {
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
     * @return the diameter
     */
    public double getDiameter() {
        return diameter;
    }

    /**
     * @param diameter the diameter to set
     */
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    /**
     * @return the hole
     */
    public double getHole() {
        return hole;
    }

    /**
     * @param hole the hole to set
     */
    public void setHole(double hole) {
        this.hole = hole;
    }
}
