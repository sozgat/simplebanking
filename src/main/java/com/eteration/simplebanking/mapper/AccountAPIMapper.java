package com.eteration.simplebanking.mapper;

import com.eteration.simplebanking.dto.account.AccountAPIResponseDTO;
import com.eteration.simplebanking.model.Account;

public class AccountAPIMapper {

    public static AccountAPIResponseDTO fromDomain(Account account){
        AccountAPIResponseDTO accountAPIResponseDTO = new AccountAPIResponseDTO();

        accountAPIResponseDTO.setAccountNumber(account.getAccountNumber());
        accountAPIResponseDTO.setOwner(account.getOwner());
        accountAPIResponseDTO.setBalance(account.getBalance());
        accountAPIResponseDTO.setTransactionList(account.getTransactions());

        return accountAPIResponseDTO;
    }
}
