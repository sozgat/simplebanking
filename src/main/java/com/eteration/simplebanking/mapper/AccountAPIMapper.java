package com.eteration.simplebanking.mapper;

import com.eteration.simplebanking.dto.account.AccountAPIRequestDTO;
import com.eteration.simplebanking.dto.account.AccountAPIResponseDTO;
import com.eteration.simplebanking.model.Account;

public class AccountAPIMapper {

    public static AccountAPIResponseDTO fromDomain(Account account){
        AccountAPIResponseDTO accountAPIResponseDTO = new AccountAPIResponseDTO();

        accountAPIResponseDTO.setAccountNumber(account.getAccountNumber());
        accountAPIResponseDTO.setOwner(account.getOwner());
        accountAPIResponseDTO.setCreateDate(account.getCreateDate());

        return accountAPIResponseDTO;
    }

    public static Account toDomain(AccountAPIRequestDTO accountAPIRequestDTO){
        Account account = new Account();
        account.setOwner(accountAPIRequestDTO.getOwner());
        return account;
    }

    private AccountAPIMapper(){
        throw new IllegalStateException("Mapper class");
    }
}
