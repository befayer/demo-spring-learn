package com.ssau.learn.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
public class BankDto implements Serializable {
    private Integer id;
    private String terbankName;
    private String bik;
    private String city;

    public BankDto(String terbankName, String bik, String city) {
        this.terbankName = terbankName;
        this.bik = bik;
        this.city = city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, terbankName, bik, city);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankDto bankDTO = (BankDto) o;
        return Objects.equals(id, bankDTO.id) && Objects.equals(terbankName, bankDTO.terbankName) &&
                Objects.equals(bik, bankDTO.bik) && Objects.equals(city, bankDTO.city);
    }

    @Override
    public String toString() {
        return "BankDTO{" +
                "id=" + id +
                ", terbankName='" + terbankName + '\'' +
                ", bik='" + bik + '\'' +
                ", city='" + city +
                '}';
    }
}
