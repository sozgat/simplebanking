package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.CheckTransaction;
import com.eteration.simplebanking.services.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.eteration.simplebanking.constant.MappingConstant.TRANSACTION_CONTROLLER_PATH;


@Slf4j
@RestController
@RequestMapping(value = TRANSACTION_CONTROLLER_PATH)
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping
    public ResponseEntity<String> checkTransaction(@RequestBody CheckTransaction checkTransaction){
        String transactionStatus = transactionService.checkTransaction(checkTransaction.getTransactionType(),checkTransaction.getTransactionApproveCode());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;");

        return new ResponseEntity<>(transactionStatus, headers, HttpStatus.OK);
    }
}
