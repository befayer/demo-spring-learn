package com.ssau.learn.dao;

import com.ssau.learn.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findClientById(int id);
    void deleteClientById(int id);
}
