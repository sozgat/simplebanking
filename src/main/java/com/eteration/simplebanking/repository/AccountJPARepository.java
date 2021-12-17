package com.eteration.simplebanking.repository;

import com.eteration.simplebanking.model.Account;

import java.util.Optional;

public interface AccountJPARepository extends BaseJPARepository<Account, Long>{
    Optional<Account> findByAccountNumber(String accountNumber);
}
