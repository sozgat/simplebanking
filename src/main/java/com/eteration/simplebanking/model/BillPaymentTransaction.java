package com.eteration.simplebanking.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Transient;


@Data
@Entity
public class BillPaymentTransaction extends WithdrawalTransaction {

    @Transient
    private String payee;

    public BillPaymentTransaction(double amount) {
        super(amount);
    }

    public BillPaymentTransaction() {
    }
}
