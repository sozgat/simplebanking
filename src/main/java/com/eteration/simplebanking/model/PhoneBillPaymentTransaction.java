package com.eteration.simplebanking.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class PhoneBillPaymentTransaction extends BillPaymentTransaction{

    private String operatorName;
    private String phoneNumber;

    public PhoneBillPaymentTransaction(String operatorName, String phoneNumber, double amount) {
        super(amount);
        this.operatorName = operatorName;
        this.phoneNumber = phoneNumber;
    }

    public PhoneBillPaymentTransaction() {
    }
}
