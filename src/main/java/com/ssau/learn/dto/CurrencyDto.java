package com.ssau.learn.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
public class CurrencyDto implements Serializable {

    private Integer id;
    private String currencyName;

    public CurrencyDto(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currencyName);
    }
    public Integer getId() {
        return id;
    }
    public String getCurrencyName() {
        return currencyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyDto that = (CurrencyDto) o;
        return Objects.equals(id, that.id) && Objects.equals(currencyName, that.currencyName);
    }

    @Override
    public String toString() {
        return "CurrencyDto{" +
                "id=" + id +
                ", currencyName='" + currencyName + '\'' +
                '}';
    }
}
