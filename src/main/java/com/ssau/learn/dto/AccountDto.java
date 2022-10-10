package com.ssau.learn.dto;

import com.ssau.learn.entity.AccountStatus;
import com.ssau.learn.entity.Bank;
import com.ssau.learn.entity.Card;
import com.ssau.learn.entity.Client;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class AccountDto {
    private Integer id;
    private List<Card> cardList;
    private Client client;
    private Bank terbank;
    private AccountStatus accountStatus;
    private Double balance;
    private Bank bank;

    public AccountDto(Integer id, List<Card> cardList, Client client, Bank terbank, AccountStatus accountStatus, Double balance, Bank bank) {
        this.id = id;
        this.cardList = cardList;
        this.client = client;
        this.terbank = terbank;
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
    public AccountStatus getAccountStatus() {
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
                ", cardList=" + cardList +
                ", client=" + client +
                ", terbank=" + terbank +
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
        return Objects.equals(id, that.id) && Objects.equals(cardList, that.cardList) && Objects.equals(client, that.client) && Objects.equals(terbank, that.terbank) && Objects.equals(accountStatus, that.accountStatus) && Objects.equals(balance, that.balance) && Objects.equals(bank, that.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardList, client, terbank, accountStatus, balance, bank);
    }
}
