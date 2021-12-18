package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.repository.TransactionJPARepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    private TransactionJPARepository transactionJPARepository;

    public TransactionService(TransactionJPARepository transactionJPARepository) {
        this.transactionJPARepository = transactionJPARepository;
    }


    public String checkTransaction(String type, String approvalCode){
            Optional<Transaction> result = transactionJPARepository.findByTypeAndApprovalCode(type, approvalCode);
            if (result.isPresent()) {
                return "SUCCESS";
            }
            else {
                throw new RuntimeException("Transaction not found! Type: " + type + " | approvalCode: " + approvalCode);
            }
    }
}
