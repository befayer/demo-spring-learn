package com.ssau.learn.dao;

import com.ssau.learn.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, UID> {
    Optional<Bank> findBankByTerbankName(String terbankName);
    Optional<Bank> findBankByBik(String bik);
    Optional<Bank> findById(long id);
    void deleteById(long id);
}
