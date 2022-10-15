package com.ssau.learn.service;

import com.ssau.learn.dao.BankRepository;
import com.ssau.learn.dto.BankDto;
import com.ssau.learn.entity.Bank;
import com.ssau.learn.mappers.BankMapper;
import liquibase.pro.packaged.L;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankService {
    private final BankRepository bankRepository;
    private final BankMapper bankMapper;

    public BankDto getBank(Long id) {
        return bankMapper.mapToBankDto(
                bankRepository.findById(id)
                        .orElse(new Bank())
        );
    }

    public Optional<Bank> save(Bank bank) {
        return Optional.of(bankRepository.save(bank));
    }

    public void delete(Long id) {
        bankRepository.deleteById(id);
    }

    public long getBankByTerbankName(String terbankName) {
        Optional<Bank> bank = bankRepository.findBankByTerbankName(terbankName);
        if (bank.isEmpty()) {
            throw new RuntimeException("The bank with terbank name " + terbankName + " not found");
        }
        return bank.get().getId();
    }

    public long getBankByBik(String bik) {
        Optional<Bank> bank = bankRepository.findBankByBik(bik);

        if (bank.isEmpty()) {
            throw new RuntimeException("The bank with bik " + bik + " not found");
        }

        return bank.get().getId();
    }
}
