package com.ssau.learn.dao;

import com.ssau.learn.entity.Bank;
import com.ssau.learn.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    Optional<Currency> findCurrencyByCurrencyName(String currencyName);
    Optional<Currency> findById(int id);
    @Transactional
    void deleteCurrencyById(int id);
}
