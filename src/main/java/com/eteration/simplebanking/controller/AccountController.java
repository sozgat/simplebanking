package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.eteration.simplebanking.constant.MappingConstant.*;


@Slf4j
@RestController
@RequestMapping(value = ACCOUNT_CONTROLLER_PATH)
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable("accountNumber") String accountNumber) throws JsonProcessingException {
        Account account = accountService.findAccount(accountNumber);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(account);

        return (new ResponseEntity<>(account, headers, HttpStatus.OK));
    }

    @PostMapping( ACCOUNT_POST_CREDIT +"/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable("accountNumber") String accountNumber,
                                                    @RequestBody DepositTransaction transaction) throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);
        String approvalCode = UUID.randomUUID().toString();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;");

        DepositTransaction depositTransaction = new DepositTransaction(transaction.getAmount());
        depositTransaction.setApprovalCode(approvalCode);

        account.post(depositTransaction);

        accountService.saveAccount(account);


        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setApprovalCode(approvalCode);

        return new ResponseEntity<TransactionStatus>(transactionStatus, headers, HttpStatus.OK);

    }
    @PostMapping( ACCOUNT_POST_DEBIT +"/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable("accountNumber") String accountNumber,
                        @RequestBody WithdrawalTransaction transaction) throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;");

        WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction(transaction.getAmount());

        account.post(withdrawalTransaction);

        accountService.saveAccount(account);

        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setApprovalCode(withdrawalTransaction.getApprovalCode());

        return new ResponseEntity<TransactionStatus>(transactionStatus, headers, HttpStatus.OK);
	}
}