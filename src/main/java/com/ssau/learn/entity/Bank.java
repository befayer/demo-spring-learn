package com.ssau.learn.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terbank_id")
    @SequenceGenerator(name = "terbank_id", sequenceName = "terbank_id", allocationSize = 1)
    @Column(name = "terbank_id", nullable = false)
    private Integer id;

    @Column(name = "terbank_name", nullable = false)
    private String terbankName;

    @Column(name = "bik", nullable = false)
    private String bik;

    @Column(name = "city", nullable = false)
    private String city;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<Account> accountList;

    public Bank(String terbankName, String bik, String city) {
        this.terbankName = terbankName;
        this.bik = bik;
        this.city = city;
        accountList = new ArrayList<>();
    }
}