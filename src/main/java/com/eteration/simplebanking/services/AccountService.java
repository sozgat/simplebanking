package com.eteration.simplebanking.services;


import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.repository.AccountJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
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
                log.info("Account found! Accont: {}", account);
            }
            else {
                log.error("Account not found! AccountNumber: {}", accountNumber);
                throw new RuntimeException("Account not found! AccountNumber: " + accountNumber);
            }
            return account;
    }

    public void saveAccount(Account account) {
        accountJPARepository.save(account);
        log.info("Account saved! Account: {}", account);
    }
}
