package com.ssau.learn.dto;

import com.ssau.learn.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
public class CardDto implements Serializable {
    private int id;
    private Account accountNumber;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Integer cvc;
    private Double balance;
    private boolean status;

    public CardDto(int id, Account accountNumber, LocalDate dateStart, LocalDate dateEnd, Integer cvc, Double balance, boolean status) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.cvc = cvc;
        this.balance = balance;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public Account getAccountNumber() {
        return accountNumber;
    }
    public LocalDate getDateStart() {
        return dateStart;
    }
    public LocalDate getDateEnd() {
        return dateEnd;
    }
    public Integer getCvc() {
        return cvc;
    }
    public Double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "CardDto{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", cvc=" + cvc +
                ", balance=" + balance +
                ", status=" + status +
                '}';
    }
}
