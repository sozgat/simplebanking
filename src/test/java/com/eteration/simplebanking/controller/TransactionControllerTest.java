package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.CheckTransaction;
import com.eteration.simplebanking.services.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
class TransactionControllerTest {

    @Spy
    @InjectMocks
    private TransactionController controller;

    @Mock
    private TransactionService service;

    @Test
    void checkTransaction() {
        String success = "SUCCESS";

        CheckTransaction checkTransaction = new CheckTransaction();
        checkTransaction.setTransactionType("DepositTransaction");
        checkTransaction.setTransactionApproveCode("225da523-9620-44c2-ad89-ad045ae406b7");

        doReturn(success).when(service).checkTransaction( "DepositTransaction","225da523-9620-44c2-ad89-ad045ae406b7");
        ResponseEntity<String> result = controller.checkTransaction(checkTransaction);
        verify(service, times(1)).checkTransaction("DepositTransaction","225da523-9620-44c2-ad89-ad045ae406b7");
        assertEquals(success, result.getBody());
    }
}