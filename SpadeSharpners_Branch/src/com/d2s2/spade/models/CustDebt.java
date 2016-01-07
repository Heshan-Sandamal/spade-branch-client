/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.models;

/**
 *
 * @author Sineth
 */
public class CustDebt {
    private String customerId;
    private double amount;
    public  static final String CUSTOMERID="customerId";
    public  static final String AMOUNT="amount";
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getDebt() {
        return amount;
    }

    public void setDebt(double debt) {
        this.amount = debt;
    }
    
}
