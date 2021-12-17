package com.eteration.simplebanking.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
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


