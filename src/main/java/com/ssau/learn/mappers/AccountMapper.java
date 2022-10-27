package com.ssau.learn.mappers;

import com.ssau.learn.dto.AccountDto;
import com.ssau.learn.entity.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountMapper {
    public AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setClient(account.getClient());
        accountDto.setBank(account.getBank());
        accountDto.setAccountStatus(account.isAccountStatus());
        accountDto.setBalance(account.getBalance());
        return accountDto;
    }

    public Account mapToAccount(AccountDto accountDto){
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setClient(accountDto.getClient());
        account.setBank(accountDto.getBank());
        account.setAccountStatus(accountDto.isAccountStatus());
        account.setBalance(accountDto.getBalance());
        return account;
    }
}
