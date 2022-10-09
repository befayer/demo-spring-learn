package com.ssau.learn.service;

import com.ssau.learn.dto.BankDto;
import com.ssau.learn.entity.Bank;

import java.util.Optional;

public interface BankService {

    Optional<Bank> save(Bank bank);

    BankDto getBank(int id);

    void delete(int id);

}
