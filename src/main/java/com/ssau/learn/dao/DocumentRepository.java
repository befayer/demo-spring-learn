package com.ssau.learn.dao;

import com.ssau.learn.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
    Optional<Document> findDocumentById(int id);
    void deleteDocumentById(int id);
}
