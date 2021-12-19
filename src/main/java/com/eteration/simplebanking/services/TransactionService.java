package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.repository.TransactionJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
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
                log.error("Transaction not found!");
                throw new RuntimeException("Transaction not found! Type: " + type + " | approvalCode: " + approvalCode);
            }
    }
}
