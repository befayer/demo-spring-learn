package com.ssau.learn.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "document_type")
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_type_id")
    @SequenceGenerator(name = "document_type_id", sequenceName = "document_type_id", allocationSize = 1)
    @Column(name = "document_type_id", nullable = false, insertable = true, updatable = true)
    private Integer id;

    @Column(name = "document_type_name", nullable = false, insertable = true, updatable = true)
    private String documentTypeName;

    public DocumentType(String documentTypeName){
        this.documentTypeName = documentTypeName;
    }
}