package com.ssau.learn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "documents")
public class Document {
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

    @ManyToOne
    @JoinColumn(name = "document_type_id", nullable = false)
    private DocumentType documentType;

    @ManyToMany(fetch = FetchType.LAZY,   cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },mappedBy = "documents")
    @JsonIgnore
    private Set<Client> clients = new HashSet<>();

    public Document(int id, LocalDate dateStart, String issueOrganization, Boolean isActive, DocumentType documentType) {
        this.id = id;
        this.dateStart = dateStart;
        this.issueOrganization = issueOrganization;
        this.isActive = isActive;
        this.documentType = documentType;
    }
}