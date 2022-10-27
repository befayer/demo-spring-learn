package com.ssau.learn.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_number", nullable = false)
    private Integer id;
    @Column(name = "date_start", nullable = false)
    private LocalDate dateStart;
    @Column(name = "date_end", nullable = false)
    private LocalDate dateEnd;
    @Column(name = "cvc", nullable = false)
    private Integer cvc;
    @Column(name = "status", nullable = false)
    private boolean status;
    @Column(name = "balance", nullable = false)
    private Double balance;
    @ManyToOne(optional = false)
    @JoinColumn(name = "account_number", nullable = false)
    private Account accountNumber;

    public Card(Account accountNumber, LocalDate dateStart, LocalDate dateEnd, Integer cvc, boolean status, Double balance) {
        this.accountNumber = accountNumber;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.cvc = cvc;
        this.status = status;
        this.balance = balance;
    }
}