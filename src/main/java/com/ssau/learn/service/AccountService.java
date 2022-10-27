package com.ssau.learn.service;

import com.ssau.learn.dao.AccountRepository;
import com.ssau.learn.dto.AccountDto;
import com.ssau.learn.dto.ClientDto;
import com.ssau.learn.entity.Account;
import com.ssau.learn.entity.Client;
import com.ssau.learn.mappers.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountDto getAccount(int id){
        return accountMapper.mapToAccountDto(
                accountRepository.findById(id)
                        .orElse(new Account())
        );
    }

    public List<AccountDto> getAccounts(){
        List<AccountDto> accountDtoList = new ArrayList<>();
        List<Account> accounts = accountRepository.findAll();
        for (Account account: accounts) {
            accountDtoList.add(accountMapper.mapToAccountDto(account));
        }
        return accountDtoList;
    }

    public AccountDto save(AccountDto accountDto) {
        Account account = accountRepository.save(accountMapper.mapToAccount(accountDto));
        return accountMapper.mapToAccountDto(account);
    }

    public void delete(int id) {
        accountRepository.deleteAccountById(id);
    }
}
