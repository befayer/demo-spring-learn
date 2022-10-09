package com.ssau.learn.entity;

import javax.persistence.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Table(name = "card_status")
@Entity
public class CardStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_status_id")
    @SequenceGenerator(name = "card_status_id", sequenceName = "card_status_id", allocationSize = 1)
    @Column(name = "card_status_id", nullable = false)
    private Integer id;

    @Column(name = "card_status_name", nullable = false)
    private String cardStatusName;

    @OneToMany(mappedBy = "cardStatus", cascade = CascadeType.ALL)
    private List<Card> cardList;

    public CardStatus(){}

    public CardStatus(String cardStatusName){
        this.cardStatusName = cardStatusName;
        cardList = new ArrayList<>();
    }

    public String getCardStatusName(){
        return cardStatusName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}