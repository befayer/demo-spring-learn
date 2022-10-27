package com.ssau.learn.service;

import com.ssau.learn.dao.BankRepository;
import com.ssau.learn.dto.BankDto;
import com.ssau.learn.entity.Bank;
import com.ssau.learn.mappers.BankMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService{
    private final BankRepository bankRepository;
    private final BankMapper bankMapper;
    private final DataSource dataSource;

    public BankDto getBank(int id) {
        return bankMapper.mapToBankDto(
                bankRepository.findById(id)
                        .orElse(new Bank())
        );
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
        Optional<Bank> bank = bankRepository.findBankByTerbankName(terbankName);
        if (bank.isEmpty()) {
            throw new RuntimeException("The bank with terbank name " + terbankName + " not found");
        }
        return bank.get().getId();
    }

    public int getBankByBik(String bik) {
        Optional<Bank> bank = bankRepository.findBankByBik(bik);

        if (bank.isEmpty()) {
            throw new RuntimeException("The bank with bik " + bik + " not found");
        }

        return bank.get().getId();
    }

    public List<BankDto> select() {
        return new NamedParameterJdbcTemplate(dataSource).query("SELECT terbank_id, terbank_name, bik, city FROM bank", Collections.emptyMap(),
                (rs, rowNum) -> {
                    BankDto bankDto = new BankDto();
                    bankDto.setId(rs.getInt("terbank_id"));
                    bankDto.setTerbankName(rs.getString("terbank_name"));
                    bankDto.setBik(rs.getString("bik"));
                    bankDto.setCity(rs.getString("city"));
                    return bankDto;
                });
    }
}
