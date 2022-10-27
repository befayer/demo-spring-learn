package com.ssau.learn.dto;

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
    private boolean accountStatus;
    private Double balance;
    private Bank bank;

    public AccountDto(Client client, boolean accountStatus, Double balance, Bank bank) {
        this.client = client;
        this.accountStatus = accountStatus;
        this.balance = balance;
        this.bank = bank;
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

    public Bank getBank() {
        return bank;
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
