package com.ssau.learn.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "terbank_id", nullable = false)
    private int id;
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
}