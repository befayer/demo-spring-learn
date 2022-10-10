package com.ssau.learn.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_number")
    @SequenceGenerator(name = "card_number", sequenceName = "card_number", allocationSize = 1)
    @Column(name = "card_number", nullable = false)
    private Integer id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "account_number", nullable = false)
    private Account accountNumber;
    @Column(name = "date_start", nullable = false)
    private LocalDate dateStart;
    @Column(name = "date_end", nullable = false)
    private LocalDate dateEnd;
    @Column(name = "cvc", nullable = false)
    private Integer cvc;
    @ManyToOne(optional = false)
    @JoinColumn(name = "card_status_id", nullable = false)
    private CardStatus cardStatus;
    @Column(name = "balance", nullable = false)
    private Double balance;

    public Card(Integer id, Account accountNumber, LocalDate dateStart, LocalDate dateEnd, Integer cvc, CardStatus cardStatus, Double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.cvc = cvc;
        this.cardStatus = cardStatus;
        this.balance = balance;
    }
}