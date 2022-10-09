package com.ssau.learn.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientDocumentId implements Serializable {
    private static final long serialVersionUID = 8430468094773173138L;
    @Column(name = "client_id", nullable = false)
    private Integer clientId;
    @Column(name = "document_id", nullable = false)
    private Integer documentId;

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, documentId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClientDocumentId entity = (ClientDocumentId) o;
        return Objects.equals(this.clientId, entity.clientId) &&
                Objects.equals(this.documentId, entity.documentId);
    }
}