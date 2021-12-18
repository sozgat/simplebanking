package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.repository.TransactionJPARepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TransactionService {

    private TransactionJPARepository transactionJPARepository;

    public TransactionService(TransactionJPARepository transactionJPARepository) {
        this.transactionJPARepository = transactionJPARepository;
    }


    public String checkTransaction(String type, String approvalCode){
        try {
            Optional<Transaction> result = transactionJPARepository.findByTypeAndApprovalCode(type, approvalCode);
            Transaction transaction = result.get();
            return "SUCCESS";
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("Transaction not found!");
        }
    }
}
