/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.models;

import java.util.ArrayList;

/**
 *
 * @author Heshan Sandamal
 */


//use the name same as in database
public class Customer {
    //make sure to same names in database
    private String customerId;
    private String name;
    private String address;
    private ArrayList<CustomerTelephone> telNoList;     //to get the customer telephone numbers with customer object

    
    public Customer(String customerId, String name, String address, ArrayList<CustomerTelephone> telNoList) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.telNoList = telNoList;
    }

    
   
    
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the telNoList
     */
    public ArrayList<CustomerTelephone> getTelNoList() {
        return telNoList;
    }

    /**
     * @param telNoList the telNoList to set
     */
    public void setTelNoList(ArrayList<CustomerTelephone> telNoList) {
        this.telNoList = telNoList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
    
}
