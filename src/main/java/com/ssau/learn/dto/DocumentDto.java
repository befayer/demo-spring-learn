package com.ssau.learn.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
public class DocumentDto implements Serializable {

    private Integer id;

    private LocalDate dateStart;

    private String issueOrganization;

    private Boolean isActive;

    private DocumentTypeDto documentType;

    private Set<ClientDto> clients = new HashSet<>();

    public DocumentDto(LocalDate dateStart, String issueOrganization, Boolean isActive, DocumentTypeDto documentType) {
        this.dateStart = dateStart;
        this.issueOrganization = issueOrganization;
        this.isActive = isActive;
        this.documentType = documentType;
        this.clients = new HashSet<>();
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

    public Boolean getActive() {
        return isActive;
    }

    public DocumentTypeDto getDocumentType() {
        return documentType;
    }

    public Set<ClientDto> getClients(){return clients;}

    //нужен ли public void addClients(ClientDto clientDto)?

    @Override
    public String toString() {
        return "DocumentDto{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", issueOrganization='" + issueOrganization + '\'' +
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
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(documentType, that.documentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateStart, issueOrganization, isActive, documentType);
    }
}
