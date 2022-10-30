package com.ssau.learn.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "document_type")
public class DocumentType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_type_id", nullable = false)
    private Integer id;

    @Column(name = "document_type_name", nullable = false)
    private String documentTypeName;

    public DocumentType(String documentTypeName){
        this.documentTypeName = documentTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentType that = (DocumentType) o;
        return Objects.equals(id, that.id) && Objects.equals(documentTypeName, that.documentTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentTypeName);
    }
}