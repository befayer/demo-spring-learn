package com.ssau.learn.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "bank")
public class Bank implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "terbank_id", nullable = false)
    private Integer id;
    @Column(name = "terbank_name", nullable = false)
    private String terbankName;
    @Column(name = "bik", nullable = false)
    private String bik;
    @Column(name = "city", nullable = false)
    private String city;

    public Bank(String terbankName, String bik, String city) {
        this.terbankName = terbankName;
        this.bik = bik;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Bank bank = (Bank) o;
        return id != null && Objects.equals(id, bank.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}