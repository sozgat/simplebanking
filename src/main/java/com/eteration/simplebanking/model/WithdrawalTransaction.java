package com.eteration.simplebanking.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import static com.eteration.simplebanking.constant.ApplicationConstant.WITHDRAWAL_DISCRIMINATOR_VALUE;

@Entity
@DiscriminatorValue(value = WITHDRAWAL_DISCRIMINATOR_VALUE)
public class WithdrawalTransaction extends Transaction{

    public WithdrawalTransaction(){
    }

    public WithdrawalTransaction(double withdrawal){
        super(withdrawal);
    }

    @Override
    public void doTransaction(Account account) throws InsufficientBalanceException {
        account.withdraw(super.getAmount());
    }
}


