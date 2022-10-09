package com.ssau.learn.dto;

import com.ssau.learn.entity.Account;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class BankDto implements Serializable {
    private Integer id;
    private String terbankName;
    private String bik;
    private String city;
    private List<Account> accountList;

    public BankDto(Integer id, String terbankName, String bik, String city) {
        this.id = id;
        this.terbankName = terbankName;
        this.bik = bik;
        this.city = city;
        accountList = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, terbankName, bik, city, accountList);
    }

    public Integer getId() {
        return id;
    }

    public String getTerbankName() {
        return terbankName;
    }

    public String getBik() {
        return bik;
    }

    public String getCity() {
        return city;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankDto bankDTO = (BankDto) o;
        return Objects.equals(id, bankDTO.id) && Objects.equals(terbankName, bankDTO.terbankName) && Objects.equals(bik, bankDTO.bik) && Objects.equals(city, bankDTO.city) && Objects.equals(accountList, bankDTO.accountList);
    }

    @Override
    public String toString() {
        return "BankDTO{" +
                "id=" + id +
                ", terbankName='" + terbankName + '\'' +
                ", bik='" + bik + '\'' +
                ", city='" + city + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
