package com.ssau.learn.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "document_type")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_type_id", nullable = false)
    private Integer id;

    @Column(name = "document_type_name", nullable = false)
    private String documentTypeName;

    public DocumentType(String documentTypeName){
        this.documentTypeName = documentTypeName;
    }
}