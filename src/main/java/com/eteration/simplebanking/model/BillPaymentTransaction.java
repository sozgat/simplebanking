package com.eteration.simplebanking.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class BillPaymentTransaction extends WithdrawalTransaction {

    public String payee;

    public BillPaymentTransaction(double amount) {
        super(amount);
    }

    public BillPaymentTransaction() {
    }
}
