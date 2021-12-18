package com.eteration.simplebanking.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import static com.eteration.simplebanking.constant.ApplicationConstant.DEPOSIT_DISCRIMINATOR_VALUE;


@Entity
@DiscriminatorValue(value = DEPOSIT_DISCRIMINATOR_VALUE)
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
