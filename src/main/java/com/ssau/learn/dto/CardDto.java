package com.ssau.learn.dto;

import com.ssau.learn.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
public class CardDto implements Serializable {
    private Integer id;
    private Account accountNumber;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Integer cvc;
    private Double balance;

    public CardDto(Integer id, Account accountNumber, LocalDate dateStart, LocalDate dateEnd, Integer cvc, Double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.cvc = cvc;
        this.balance = balance;
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardDto cardDto = (CardDto) o;
        return Objects.equals(id, cardDto.id) && Objects.equals(accountNumber, cardDto.accountNumber) && Objects.equals(dateStart, cardDto.dateStart) && Objects.equals(dateEnd, cardDto.dateEnd) && Objects.equals(cvc, cardDto.cvc) && Objects.equals(balance, cardDto.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, dateStart, dateEnd, cvc, balance);
    }
}
