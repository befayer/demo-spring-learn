package com.ssau.learn.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "account", uniqueConstraints = {
        @UniqueConstraint(columnNames = "account_number"),
        @UniqueConstraint(columnNames = "client_id")
})
@Data
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @Column(name = "account_number", nullable = false)
    private Integer id;
    @Column(name = "balance", nullable = false)
    private Double balance;
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @ManyToOne(optional = false)
    @JoinColumn(name = "terbank_id", nullable = false)
    private Bank bank;
    @ManyToOne(optional = false)
    @JoinColumn(name = "account_status_id", nullable = false)
    private AccountStatus accountStatus;

    public Account(Integer id, List<Card> cardList, Client client, Bank terbank, AccountStatus accountStatus, Double balance) {
        this.id = id;
        this.client = client;
        this.bank = terbank;
        this.accountStatus = accountStatus;
        this.balance = balance;
    }
}