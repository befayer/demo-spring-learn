package com.ssau.learn.dto;

import com.ssau.learn.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CardDto implements Serializable {
    private Integer id;
    private Account accountNumber;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Integer cvc;
    private Double balance;
    private boolean status;

    public CardDto(Account accountNumber, LocalDate dateStart, LocalDate dateEnd, Integer cvc, Double balance, boolean status) {
        this.accountNumber = accountNumber;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.cvc = cvc;
        this.balance = balance;
        this.status = status;
    }

    public Integer getId() {
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
