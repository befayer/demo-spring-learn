package com.ssau.learn.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_id")
    @SequenceGenerator(name = "document_id", sequenceName = "document_id", allocationSize = 1)
    @Column(name = "document_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "date_start", nullable = false)
    private LocalDate dateStart;

    @Column(name = "issue_organization", nullable = false, length = 70)
    private String issueOrganization;

    @Column(name = "issue_code", length = 30)
    private String issueCode;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @ManyToOne
    @JoinColumn(name = "document_type_id", nullable = false)
    private DocumentType documentType;

    public Document(Integer id, LocalDate dateStart, String issueOrganization, String issueCode, Boolean isActive, DocumentType documentType) {
        this.id = id;
        this.dateStart = dateStart;
        this.issueOrganization = issueOrganization;
        this.issueCode = issueCode;
        this.isActive = isActive;
        this.documentType = documentType;
    }
}