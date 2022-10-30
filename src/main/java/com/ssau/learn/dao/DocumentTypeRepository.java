package com.ssau.learn.dao;

import com.ssau.learn.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Integer> {
    Optional<DocumentType> findDocumentTypeById(int id);
    @Transactional
    void deleteDocumentTypeById(int id);
    Optional<DocumentType> getDocumentTypeByDocumentTypeName(String documentTypeName);
}
