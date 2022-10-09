package com.ssau.learn.dao;

import com.ssau.learn.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;

public interface ClientRepository extends JpaRepository<Client, UID> {

}
