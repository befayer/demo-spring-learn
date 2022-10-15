package com.ssau.learn.dto;

import com.ssau.learn.entity.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class DocumentTypeDto implements Serializable {
    private int id;
    private String documentTypeName;
    private List<Document> documentList;

    public DocumentTypeDto(int id, String documentTypeName) {
        this.id = id;
        this.documentTypeName = documentTypeName;
        documentList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    @Override
    public String toString() {
        return "DocumentTypeDto{" +
                "id=" + id +
                ", documentTypeName='" + documentTypeName + '\'' +
                ", documentList=" + documentList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentTypeDto that = (DocumentTypeDto) o;
        return Objects.equals(id, that.id) && Objects.equals(documentTypeName, that.documentTypeName) && Objects.equals(documentList, that.documentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentTypeName, documentList);
    }
}
