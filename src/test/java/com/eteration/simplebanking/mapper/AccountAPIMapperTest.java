package com.eteration.simplebanking.mapper;

import com.eteration.simplebanking.dto.account.AccountAPIRequestDTO;
import com.eteration.simplebanking.dto.account.AccountAPIResponseDTO;
import com.eteration.simplebanking.model.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AccountAPIMapperTest {

    @Test
    void fromDomain() {
        Account account = new Account("Kerem Karaca", "17892");
        AccountAPIResponseDTO accountAPIResponseDTO = AccountAPIMapper.fromDomain(account);
        assertEquals("17892", accountAPIResponseDTO.getAccountNumber());
    }

    @Test
    void toDomain() {
        AccountAPIRequestDTO accountAPIRequestDTO = new AccountAPIRequestDTO();
        accountAPIRequestDTO.setOwner("Kerem Karaca");

        Account account = AccountAPIMapper.toDomain(accountAPIRequestDTO);
        assertEquals("Kerem Karaca", account.getOwner());
    }
}