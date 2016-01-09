/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.models;

/**
 *
 * @author Heshan Sandamal
 */
public class CustomerTelephone {
    private String customerId;
    private String telNo;
    
    public static final String CUSTOMERID = "customerId";
    public static final String TELNO = "telNo";

    public CustomerTelephone(String customerId, String telNo) {
        this.customerId = customerId;
        this.telNo = telNo;
    }
    
    
    
    //to auto generate getters and setters---- rightclick->refactor->encapsulated fields->selectAll->ok

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the telNo
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * @param telNo the telNo to set
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    
    
}
