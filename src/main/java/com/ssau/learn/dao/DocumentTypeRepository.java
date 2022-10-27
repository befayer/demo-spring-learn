package com.ssau.learn.dao;

import com.ssau.learn.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Integer> {
    Optional<DocumentType> findDocumentTypeById(int id);
    void deleteDocumentTypeById(int id);
}
