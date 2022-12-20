package com.ssau.learn.dao;

import com.ssau.learn.entity.Client;
import com.ssau.learn.entity.Document;
import liquibase.pro.packaged.D;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
    Optional<Document> findDocumentById(int id);
    @Transactional
    void deleteDocumentById(int id);

    List<Document> findByClients(Client clients);
    List<Document> findDocumentsByClients(Client client);
}
