package com.eteration.simplebanking.services;


import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.repository.AccountJPARepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountJPARepository accountJPARepository;

    public AccountService(AccountJPARepository accountJPARepository) {
        this.accountJPARepository = accountJPARepository;
    }

    public Account findAccount(String accountNumber){
            Optional<Account> result = accountJPARepository.findByAccountNumber(accountNumber);
            Account account;
            if (result.isPresent()) {
                account = result.get();
            }
            else {
                throw new RuntimeException("Account not found! AccountNumber: " + accountNumber);
            }
            return account;
    }

    public void saveAccount(Account account) {
        accountJPARepository.save(account);
    }
}
