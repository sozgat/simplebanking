package com.eteration.simplebanking.services;


import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.repository.AccountJPARepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountJPARepository accountJPARepository;

    public AccountService(AccountJPARepository accountJPARepository) {
        this.accountJPARepository = accountJPARepository;
    }

    public Account findAccount(String accountNumber){
        try {
            Optional<Account> result = accountJPARepository.findByAccountNumber(accountNumber);
            Account account = result.get();
            return account;
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("Account not found! Message: " + e.getMessage());
        }
    }

    public void saveAccount(Account account) {
        accountJPARepository.save(account);
    }
}
