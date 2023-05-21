package com.example.hackathon.services;

import com.example.hackathon.entities.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AccountService extends UserDetailsService {

    List<Account> getAllAccounts();
    Account getAccountById(Long id);
    Account saveAccount(Account account);
    Account updateAccount(Long id, Account updatedAccount);
    void deleteAccount(Long id);
    Account getAccountByUsername(String username);
}
