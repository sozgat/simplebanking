package com.eteration.simplebanking.model;
import javax.persistence.Entity;

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
