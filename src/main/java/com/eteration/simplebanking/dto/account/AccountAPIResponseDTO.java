package com.eteration.simplebanking.dto.account;

import com.eteration.simplebanking.model.Transaction;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AccountAPIResponseDTO  {
    private String accountNumber;
    private String owner;
    private double balance;
    private LocalDateTime createDate;
    private List<Transaction> transactionList;
}
