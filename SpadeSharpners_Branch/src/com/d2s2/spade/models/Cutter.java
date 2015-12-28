/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.models;

/**
 *
 * @author Heshan Sandamal
 */
public class Cutter extends Item{
    
    private String size;
    private int noOfTips;
    private String thickness;

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
     * @return the noOfTips
     */
    public int getNoOfTips() {
        return noOfTips;
    }

    /**
     * @param noOfTips the noOfTips to set
     */
    public void setNoOfTips(int noOfTips) {
        this.noOfTips = noOfTips;
    }

    /**
     * @return the thickness
     */
    public String getThickness() {
        return thickness;
    }

    /**
     * @param thickness the thickness to set
     */
    public void setThickness(String thickness) {
        this.thickness = thickness;
    }
    
    
    
}
