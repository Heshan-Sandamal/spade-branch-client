/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.models;

/**
 *
 * @author Heshan Sandamal
 */
public class PlanerBlade extends Item{

 private String type;
 private String size;

    
 public static final String PLANERBLADE="Planer Blade";
 public static final String TYPE="type";
 public static final String SIZE="size";

    public PlanerBlade(String type, String size) {
        this.type=type;
        this.size=size;
    }

    public PlanerBlade() {
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
