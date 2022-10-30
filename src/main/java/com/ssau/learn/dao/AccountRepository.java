package com.ssau.learn.dao;

import com.ssau.learn.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findById(int id);
    @Transactional
    void deleteAccountById(int id);
}
