package com.ssau.learn.service;

import com.ssau.learn.dao.BankRepository;
import com.ssau.learn.dto.BankDto;
import com.ssau.learn.entity.Bank;
import com.ssau.learn.exception.BankNotFoundException;
import com.ssau.learn.mappers.BankMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService{

    private final BankRepository bankRepository;
    private final BankMapper bankMapper;

    public BankDto getBank(int id) {
        return bankMapper.mapToBankDto(bankRepository.findById(id)
                .orElseThrow(() -> new BankNotFoundException("Bank with id " + id + " was not found")));
    }

    public List<BankDto> getBanks() {
        List<BankDto> bankDtoList = new ArrayList<>();
        List<Bank> banks = bankRepository.findAll();
        for (Bank bank : banks) {
            bankDtoList.add(bankMapper.mapToBankDto(bank));
        }
        return bankDtoList;
    }

    public BankDto save(BankDto bankDto) {
        Bank bank = bankRepository.save(bankMapper.mapToBank(bankDto));
        return bankMapper.mapToBankDto(bank);
    }

    public void delete(int id) {
        bankRepository.deleteBankById(id);
    }

    public int getBankByTerbankName(String terbankName) {
        Bank bank = bankRepository.findBankByTerbankName(terbankName).orElseThrow();
        return bank.getId();
    }

    public int getBankByBik(String bik) {
        Bank bank = bankRepository.findBankByBik(bik).orElseThrow();
        return bank.getId();
    }
}
