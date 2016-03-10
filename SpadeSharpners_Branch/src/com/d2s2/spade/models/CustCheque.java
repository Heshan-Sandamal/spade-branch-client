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
public class CustCheque {
    private String paymentId;
    private String chequeNo;
    private String bank;
    private Date expiryDate;
    private Date issueDate;
    private String status;
    public static final String PAYMENTID="paymentId";
    public static final String CHEQUENO="chequeNo";
    public static final String BANK="bank";
    public static final String EXPIRYDATE="expDate";
    public static final String ISSUEDATE="issueDate";
    public static final String STATUS="status";

    public void setStatus(String status) {
        this.status = status;
    }
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getStatus() {
       return status;
    }
    
    
    
    
}
