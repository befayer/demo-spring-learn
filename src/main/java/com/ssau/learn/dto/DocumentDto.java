package com.ssau.learn.dto;

import com.ssau.learn.entity.ClientDocument;
import com.ssau.learn.entity.DocumentType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class DocumentDto implements Serializable {
    private Integer id;
    private LocalDate dateStart;
    private String issueOrganization;
    private String issueCode;
    private Boolean isActive;
    private List<ClientDocument> clientDocumentList;
    private DocumentType documentType;

    public DocumentDto(Integer id, LocalDate dateStart, String issueOrganization, String issueCode, Boolean isActive, DocumentType documentType) {
        this.id = id;
        this.dateStart = dateStart;
        this.issueOrganization = issueOrganization;
        this.issueCode = issueCode;
        this.isActive = isActive;
        clientDocumentList = new ArrayList<>();
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

    public List<ClientDocument> getClientDocumentList() {
        return clientDocumentList;
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
                ", clientDocumentList=" + clientDocumentList +
                ", documentType=" + documentType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentDto that = (DocumentDto) o;
        return Objects.equals(id, that.id) && Objects.equals(dateStart, that.dateStart) && Objects.equals(issueOrganization, that.issueOrganization) && Objects.equals(issueCode, that.issueCode) && Objects.equals(isActive, that.isActive) && Objects.equals(clientDocumentList, that.clientDocumentList) && Objects.equals(documentType, that.documentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateStart, issueOrganization, issueCode, isActive, clientDocumentList, documentType);
    }
}
