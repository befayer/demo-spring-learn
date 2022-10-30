package com.ssau.learn.mappers;

import com.ssau.learn.dto.AccountDto;
import com.ssau.learn.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountMapper {

    @Autowired
    private BankMapper bankMapper;

    @Autowired
    private CurrencyMapper currencyMapper;

    public AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setClient(account.getClient());
        accountDto.setBank(bankMapper.mapToBankDto(account.getBank()));
        accountDto.setAccountStatus(account.isAccountStatus());
        accountDto.setBalance(account.getBalance());
        accountDto.setCurrency(currencyMapper.mapToCurrencyDto(account.getCurrency()));
    return accountDto;
    }

    public Account mapToAccount(AccountDto accountDto){
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setClient(accountDto.getClient());
        account.setBank(bankMapper.mapToBank(accountDto.getBank()));
        account.setAccountStatus(accountDto.isAccountStatus());
        account.setBalance(accountDto.getBalance());
        account.setCurrency(currencyMapper.mapToCurrency(accountDto.getCurrency()));
        return account;
    }
}
