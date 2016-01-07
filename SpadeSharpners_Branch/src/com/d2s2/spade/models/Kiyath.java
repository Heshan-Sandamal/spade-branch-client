/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.models;

/**
 *
 * @author Heshan Sandamal
 */
public class Kiyath extends Item{
    
    private  String size;
    private int noOfTips;
    
    
    public static final String SIZE="size";
    public static final String KIYATH="Kiyath";
    public static final String NOOFTIPS="noOfTips";

    public Kiyath(String size, int noOfTips) {
        this.size=size;
        this.noOfTips=noOfTips;
    }

    public Kiyath() {
        
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
    
    
}
