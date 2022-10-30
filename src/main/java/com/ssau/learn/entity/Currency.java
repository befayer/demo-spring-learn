package com.ssau.learn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "currency")
public class Currency  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_id", nullable = false)
    private Integer id;

    @Column(name = "currency_name", nullable = false)
    private String currencyName;

    public Currency(String currencyName) {
        this.currencyName = currencyName;
    }
}