package com.ssau.learn.dao;

import com.ssau.learn.entity.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;

public interface CardStatusRepository extends JpaRepository<CardStatus, UID> {

}
