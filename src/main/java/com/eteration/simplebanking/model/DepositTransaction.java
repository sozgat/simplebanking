package com.eteration.simplebanking.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class DepositTransaction extends Transaction  {

    public DepositTransaction() {
    }

    public DepositTransaction(double deposit) {
        super(deposit);
    }

    @Override
    public void doTransaction(Account account) throws InsufficientBalanceException {
        account.deposit(super.getAmount());
    }
}
