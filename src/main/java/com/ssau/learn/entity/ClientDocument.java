package com.ssau.learn.entity;

import javax.persistence.*;

@Table(name = "client_documents")
@Entity
public class ClientDocument {
    //?
    @EmbeddedId
    private ClientDocumentId id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "document_id", referencedColumnName = "document_id", insertable = false, updatable = false)
    private Document document;

    @ManyToOne
    @JoinColumn(name = "client_client_id")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientDocumentId getId() {
        return id;
    }

    public void setId(ClientDocumentId id) {
        this.id = id;
    }
}