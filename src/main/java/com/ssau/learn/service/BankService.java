package com.ssau.learn.service;

import com.ssau.learn.dto.BankDto;

import java.util.List;


public interface BankService {
    public BankDto getBank(int id);

    public List<BankDto> getBanks();

    public BankDto save(BankDto bankDto);

    public void delete(int id);

    public int getBankByTerbankName(String terbankName);

    public int getBankByBik(String bik);

    public List<BankDto> select();
}
