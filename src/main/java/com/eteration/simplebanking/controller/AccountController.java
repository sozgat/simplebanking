package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.dto.account.AccountAPIRequestDTO;
import com.eteration.simplebanking.dto.account.AccountAPIResponseDTO;
import com.eteration.simplebanking.mapper.AccountAPIMapper;
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

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.UUID;

import static com.eteration.simplebanking.constant.ApplicationConstant.API_RESPONSE_STATUS_OK;
import static com.eteration.simplebanking.constant.MappingConstant.*;


@Slf4j
@RestController
@RequestMapping(value = ACCOUNT_CONTROLLER_PATH)
public class AccountController {

    private static final String HEADER_NAME_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_VALUE_JSON = "application/json;"; // Compliant

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable("accountNumber") String accountNumber) throws JsonProcessingException {
        Account account = accountService.findAccount(accountNumber);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HEADER_NAME_CONTENT_TYPE, HEADER_VALUE_JSON);
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
        headers.add(HEADER_NAME_CONTENT_TYPE, HEADER_VALUE_JSON);

        DepositTransaction depositTransaction = new DepositTransaction(transaction.getAmount());
        depositTransaction.setApprovalCode(approvalCode);

        account.post(depositTransaction);

        accountService.saveAccount(account);


        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setApprovalCode(approvalCode);
        transactionStatus.setStatus(API_RESPONSE_STATUS_OK);

        return new ResponseEntity<>(transactionStatus, headers, HttpStatus.OK);

    }

    @PostMapping( ACCOUNT_POST_DEBIT +"/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable("accountNumber") String accountNumber,
                        @RequestBody WithdrawalTransaction transaction) throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HEADER_NAME_CONTENT_TYPE, HEADER_VALUE_JSON);

        WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction(transaction.getAmount());

        account.post(withdrawalTransaction);

        accountService.saveAccount(account);

        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setApprovalCode(withdrawalTransaction.getApprovalCode());
        transactionStatus.setStatus(API_RESPONSE_STATUS_OK);

        return new ResponseEntity<>(transactionStatus, headers, HttpStatus.OK);
	}

    @PostMapping(NEW_ACCOUNT_POST)
    public ResponseEntity<AccountAPIResponseDTO> saveAccount(@Valid @RequestBody AccountAPIRequestDTO accountAPIRequestDTO) throws JsonProcessingException {

        Account account = AccountAPIMapper.toDomain(accountAPIRequestDTO);
        account.setAccountNumber(generateAccountNumber());
        account.setBalance(BigDecimal.ZERO);
        accountService.saveAccount(account);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HEADER_NAME_CONTENT_TYPE, HEADER_VALUE_JSON);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(account);

        AccountAPIResponseDTO accountAPIResponseDTO = AccountAPIMapper.fromDomain(account);

        return (new ResponseEntity<>(accountAPIResponseDTO, headers, HttpStatus.OK));
    }

    public String generateAccountNumber(){
        return randNumberBetween(100,999) + "-" + randNumberBetween(1000,999999);
    }

    public int randNumberBetween(int minimum, int maximum){
        return (int)((Math.random()*maximum) + minimum);
    }
}