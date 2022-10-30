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
    private DocumentTypeDto documentTypeDto;
    private Set<ClientDto> clientDtoSet = new HashSet<>();

    public DocumentDto(LocalDate dateStart, String issueOrganization, Boolean isActive, DocumentTypeDto documentType) {
        this.dateStart = dateStart;
        this.issueOrganization = issueOrganization;
        this.isActive = isActive;
        this.documentTypeDto = documentType;
        this.clientDtoSet = new HashSet<>();
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
    public DocumentTypeDto getDocumentTypeDto() {
        return documentTypeDto;
    }
    public Set<ClientDto> getClients(){return clientDtoSet;}

    //нужен ли public void addClients(ClientDto clientDto)?

    @Override
    public String toString() {
        return "DocumentDto{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", issueOrganization='" + issueOrganization + '\'' +
                ", isActive=" + isActive +
                ", documentType=" + documentTypeDto +
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
                Objects.equals(documentTypeDto, that.documentTypeDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateStart, issueOrganization, isActive, documentTypeDto);
    }
}
