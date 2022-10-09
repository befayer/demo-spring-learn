package com.ssau.learn.dao;

import com.ssau.learn.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, UID> {

    Optional<Document> findDocumentById(int id);

}
