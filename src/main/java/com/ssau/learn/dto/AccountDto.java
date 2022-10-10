package com.ssau.learn.dto;

import com.ssau.learn.entity.AccountStatus;
import com.ssau.learn.entity.Bank;
import com.ssau.learn.entity.Client;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;

@Data
@NoArgsConstructor
public class AccountDto {
    private Integer id;
    private Client client;
    private AccountStatus accountStatus;
    private Double balance;
    private Bank bank;

    public AccountDto(Integer id, Client client, AccountStatus accountStatus, Double balance, Bank bank) {
        this.id = id;
        this.client = client;
        this.accountStatus = accountStatus;
        this.balance = balance;
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", client=" + client +
                ", accountStatus=" + accountStatus +
                ", balance=" + balance +
                ", bank=" + bank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto that = (AccountDto) o;
        return Objects.equals(id, that.id) && Objects.equals(client, that.client) && Objects.equals(accountStatus, that.accountStatus) && Objects.equals(balance, that.balance) && Objects.equals(bank, that.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, accountStatus, balance, bank);
    }
}
