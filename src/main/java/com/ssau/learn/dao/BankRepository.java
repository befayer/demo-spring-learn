package com.ssau.learn.dao;

import com.ssau.learn.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Integer> {
    Optional<Bank> findBankByTerbankName(String terbankName);
    Optional<Bank> findBankByBik(String bik);
    Optional<Bank> findById(int id);
    @Transactional
    void deleteBankById(int id);
}
