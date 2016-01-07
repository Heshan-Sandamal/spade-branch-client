/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.models;

/**
 *
 * @author Heshan Sandamal
 */
public class RouterCutter extends Item{
    private String size;
    
    public static final String ROUTERCUTTER="Router Cutter";
    public static final String SIZE="size";

    public RouterCutter(String size) {
        this.size=size;
    }

    public RouterCutter() {
        
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
}
