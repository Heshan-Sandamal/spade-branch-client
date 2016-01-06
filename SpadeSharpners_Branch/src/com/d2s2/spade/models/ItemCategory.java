/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.models;

/**
 *
 * @author Heshan Sandamal
 */
public class ItemCategory {

    private String itemCode;
    private String category;
    public static final String ITEMCODE = "itemCode";
    public static final String CATEGORY = "category";

    public ItemCategory(String itemCode, String category) {
        this.itemCode = itemCode;
        this.category = category;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        String itemCategory = (String) obj;
        if (this.getItemCode().equals(itemCategory)) {
            return true;
        } else {
            return false;
        }
    }
}
