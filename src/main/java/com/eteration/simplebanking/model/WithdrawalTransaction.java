package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation
public class WithdrawalTransaction extends Transaction{

    public WithdrawalTransaction(){
    }

    public WithdrawalTransaction(double withdrawal){
        super(withdrawal);
        this.setType("WithdrawalTransaction");
    }

    @Override
    public void doTransaction(Account account) throws InsufficientBalanceException {
        account.withdraw(super.getAmount());
    }
}


