package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.services.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.eteration.simplebanking.constant.MappingConstant.*;


@Slf4j
@RestController
@RequestMapping(value = TRANSACTION_CONTROLLER_PATH)
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping
    public ResponseEntity<String> credit(@RequestBody CheckTransaction checkTransaction) throws InsufficientBalanceException {
        String transactionStatus = transactionService.checkTransaction(checkTransaction.getTransactionType(),checkTransaction.getTransactionApproveCode());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;");

        return new ResponseEntity<String>(transactionStatus, headers, HttpStatus.OK);
    }
}
