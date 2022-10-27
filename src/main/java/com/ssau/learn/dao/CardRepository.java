package com.ssau.learn.dao;

import com.ssau.learn.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Integer> {
    Optional<Card> findCardById(int id);
    @Transactional
    void deleteCardById(int id);
}
