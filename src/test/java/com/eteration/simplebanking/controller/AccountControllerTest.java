package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.dto.account.AccountAPIRequestDTO;
import com.eteration.simplebanking.dto.account.AccountAPIResponseDTO;
import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.services.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
class AccountControllerTest {

    @Spy
    @InjectMocks
    private AccountController controller;

    @Mock
    private AccountService service;

    @Test
    void saveAccount() throws JsonProcessingException {
        Account account = new Account("Kerem Karaca", "17892");

        AccountAPIRequestDTO accountAPIRequestDTO = new AccountAPIRequestDTO();
        accountAPIRequestDTO.setOwner("Kerem Karaca");

        doNothing().when(service).saveAccount(account);
        ResponseEntity<AccountAPIResponseDTO> result = controller.saveAccount(accountAPIRequestDTO);
        assertEquals("200 OK", result.getStatusCode().toString());
        assertEquals("Kerem Karaca", result.getBody().getOwner());
    }

    @Test
    void generateAccountNumber() {
        int firstNumber = 123;
        int secondNumber = 45678;

        doReturn(firstNumber).when(controller).randNumberBetween(100,999);
        doReturn(secondNumber).when(controller).randNumberBetween(1000,999999);

        String accountNumber = controller.generateAccountNumber();
        assertEquals("123-45678", accountNumber);
    }

    @Test
    void randNumberBetween() {
        List<Integer> actual = Arrays.asList(1,2,3);
        int toCheckValue = controller.randNumberBetween(1,3);
        assertThat(actual, hasItems(toCheckValue));
    }

    @Test
    void transactionStatus(){
        TransactionStatus transactionStatus = controller.transactionStatus("f344bf99-fd4a-4d4a-8ce5-df09daee84a0");
        assertEquals("f344bf99-fd4a-4d4a-8ce5-df09daee84a0", transactionStatus.getApprovalCode());
        assertEquals("OK", transactionStatus.getStatus());
    }

}