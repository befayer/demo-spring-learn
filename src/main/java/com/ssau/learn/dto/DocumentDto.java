package com.ssau.learn.dto;

import com.ssau.learn.entity.DocumentType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
public class DocumentDto implements Serializable {
    private Integer id;
    private LocalDate dateStart;
    private String issueOrganization;
    private String issueCode;
    private Boolean isActive;
    private DocumentType documentType;

    public DocumentDto(Integer id, LocalDate dateStart, String issueOrganization, String issueCode, Boolean isActive, DocumentType documentType) {
        this.id = id;
        this.dateStart = dateStart;
        this.issueOrganization = issueOrganization;
        this.issueCode = issueCode;
        this.isActive = isActive;
        this.documentType = documentType;
    }

    public Integer getId() {
        return id;
    }
    public LocalDate getDateStart() {
        return dateStart;
    }
    public String getIssueOrganization() {
        return issueOrganization;
    }
    public String getIssueCode() {
        return issueCode;
    }
    public Boolean getActive() {
        return isActive;
    }
    public DocumentType getDocumentType() {
        return documentType;
    }

    @Override
    public String toString() {
        return "DocumentDto{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", issueOrganization='" + issueOrganization + '\'' +
                ", issueCode='" + issueCode + '\'' +
                ", isActive=" + isActive +
                ", documentType=" + documentType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentDto that = (DocumentDto) o;
        return Objects.equals(id, that.id) && Objects.equals(dateStart, that.dateStart) &&
                Objects.equals(issueOrganization, that.issueOrganization) &&
                Objects.equals(issueCode, that.issueCode) && Objects.equals(isActive, that.isActive) &&
                Objects.equals(documentType, that.documentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateStart, issueOrganization, issueCode, isActive, documentType);
    }
}
