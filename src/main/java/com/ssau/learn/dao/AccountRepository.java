package com.ssau.learn.dao;

import com.ssau.learn.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, UID> {

    Optional<Account> findById(int id);
}
