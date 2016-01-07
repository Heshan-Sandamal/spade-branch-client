/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.models;

import java.sql.Date;

/**
 *
 * @author Sineth
 */
public class CustPayment {
    private String paymentId;
    private String customerId;
    private paymentType type;
    private double discount;
    private double amount;
    private Date date;
    
    public static final String PAYMENTID="paymentId";
    public static final String CUSTOMERID="customerId"; 
    public static final String TYPE="type";
    public static final String DISCOUNT="discount";
    public static final String AMOUNT="amount";
    public static final String DATE= "date";
    
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public paymentType getType() {
        return type;
    }

    public void setType(paymentType type) {
        this.type = type;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
