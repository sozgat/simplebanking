package com.eteration.simplebanking.repository;

import com.eteration.simplebanking.model.Transaction;

import java.util.Optional;

public interface TransactionJPARepository extends BaseJPARepository<Transaction, Long>{
    Optional<Transaction> findByTypeAndApprovalCode(String type, String approvalCode);
}