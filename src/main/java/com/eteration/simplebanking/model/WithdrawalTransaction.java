package com.eteration.simplebanking.model;

import lombok.Data;

@Data
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


