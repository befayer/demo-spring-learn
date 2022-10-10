package com.ssau.learn.mappers;

import com.ssau.learn.dto.BankDto;
import com.ssau.learn.entity.Bank;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class BankMapper {
    public BankDto mapToBankDto(Bank bank){
        BankDto bankDto = new BankDto();
        bankDto.setId(bank.getId());
        bankDto.setTerbankName(bank.getTerbankName());
        bankDto.setBik(bank.getBik());
        bankDto.setCity(bank.getCity());
        return bankDto;
    }

    public Bank mapToBank(BankDto bankDto){
        Bank bank = new Bank();
        bank.setId(bankDto.getId());
        bank.setTerbankName(bankDto.getTerbankName());
        bank.setBik(bankDto.getBik());
        bank.setCity(bankDto.getCity());
        return bank;
    }
}
