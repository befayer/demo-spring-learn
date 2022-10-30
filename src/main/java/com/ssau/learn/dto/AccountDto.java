package com.ssau.learn.dto;

import com.ssau.learn.entity.Bank;
import com.ssau.learn.entity.Client;
import com.ssau.learn.entity.Currency;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
public class AccountDto implements Serializable {

    private Integer id;
    private Client client;
    private Boolean accountStatus;
    private Double balance;
    private BankDto bank;
    private CurrencyDto currency; //или CurrencyDto?

    public AccountDto(Client client, Boolean accountStatus, Double balance, BankDto bank, CurrencyDto currency) {
        this.client = client;
        this.accountStatus = accountStatus;
        this.balance = balance;
        this.bank = bank;
        this.currency = currency;
    }

    public Integer getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public Double getBalance() {
        return balance;
    }

    public BankDto getBank() {
        return bank;
    }

    public CurrencyDto getCurrency() {
        return currency;
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
        return accountStatus == that.accountStatus && Objects.equals(id, that.id) && Objects.equals(client, that.client) && Objects.equals(balance, that.balance) && Objects.equals(bank, that.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, accountStatus, balance, bank);
    }
}
