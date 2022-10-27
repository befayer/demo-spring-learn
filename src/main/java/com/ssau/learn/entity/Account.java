package com.ssau.learn.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number", nullable = false)
    private Integer id;
    @Column(name = "status")
    private boolean accountStatus = true;
    @Column(name = "balance")
    private Double balance;
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(optional = false)
    @JoinColumn(name = "terbank_id")
    private Bank bank;

    @ManyToOne(optional = false)
    @JoinColumn(name = "currency_id")
    private Currency currency;

    public Account(Client client, Bank terbank, boolean accountStatus, Double balance) {
        this.client = client;
        this.bank = terbank;
        this.accountStatus = accountStatus;
        this.balance = balance;
    }
}