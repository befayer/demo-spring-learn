package com.ssau.learn.dao;

import com.ssau.learn.entity.Bank;
import com.ssau.learn.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.Optional;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, UID> {
    Optional<DocumentType> findDocumentTypeById(int id);
}
