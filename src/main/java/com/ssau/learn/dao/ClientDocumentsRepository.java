package com.ssau.learn.dao;

import com.ssau.learn.entity.ClientDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;

public interface ClientDocumentsRepository extends JpaRepository<ClientDocument, UID> {

}
