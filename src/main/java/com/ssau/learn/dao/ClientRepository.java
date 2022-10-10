package com.ssau.learn.dao;

import com.ssau.learn.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, UID> {
    Optional<Client> findClientById(int id);
}
