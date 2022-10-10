package com.ssau.learn.service;

import com.ssau.learn.dao.AccountRepository;
import com.ssau.learn.dto.AccountDto;
import com.ssau.learn.entity.Account;
import com.ssau.learn.mappers.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountDto getAccount(int id){
        return accountMapper.maoToAccountDto(
                accountRepository.findById(id)
                        .orElse(new Account())
        );
    }
}
