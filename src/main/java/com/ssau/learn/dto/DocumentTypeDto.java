package com.ssau.learn.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@Component
public class DocumentTypeDto implements Serializable {

    private Integer id;
    private String documentTypeName;

    public DocumentTypeDto(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }

    public Integer getId() {
        return id;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public void setDocumentTypeName(String documentTypeName){
        this.documentTypeName = documentTypeName;
    }

    @Override
    public String toString() {
        return "DocumentTypeDto{" +
                "id=" + id +
                ", documentTypeName='" + documentTypeName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentTypeDto that = (DocumentTypeDto) o;
        return Objects.equals(id, that.id) && Objects.equals(documentTypeName, that.documentTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentTypeName);
    }
}
