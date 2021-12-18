package com.eteration.simplebanking.model;

import lombok.Data;

@Data
public class CheckTransaction extends Transaction{

    private String transactionType;
    private String transactionApproveCode;

    @Override
    public void doTransaction(Account account) throws InsufficientBalanceException {
        throw new UnsupportedOperationException();
    }
}
