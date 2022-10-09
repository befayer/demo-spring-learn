package com.ssau.learn.dao;

import com.ssau.learn.dto.BankDto;
import com.ssau.learn.entity.Bank;
import com.ssau.learn.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, UID> {
    Optional<Card> findCardById(int id);
}
