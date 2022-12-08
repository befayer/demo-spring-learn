package com.ssau.learn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssau.learn.dto.DocumentTypeDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "documents")
public class Document  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id", nullable = false)
    private Integer id;

    @Column(name = "start_date", nullable = false)
    private LocalDate dateStart;

    @Column(name = "issue_organization", nullable = false)
    private String issueOrganization;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @ManyToOne(optional = false)
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

    @ManyToMany(fetch = FetchType.LAZY,   cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },mappedBy = "documents")
    @JsonIgnore
    private Set<Client> clients = new HashSet<>();

    public Document(LocalDate dateStart, String issueOrganization, Boolean isActive, DocumentType documentType) {
        this.dateStart = dateStart;
        this.issueOrganization = issueOrganization;
        this.isActive = isActive;
        this.documentType = documentType;
        this.clients = new HashSet<>();
    }
}