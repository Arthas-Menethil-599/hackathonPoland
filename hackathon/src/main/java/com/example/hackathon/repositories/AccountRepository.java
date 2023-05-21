package com.example.hackathon.repositories;

import com.example.hackathon.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account getById(Long id);
    Account getAccountByUsername(String username);

}
