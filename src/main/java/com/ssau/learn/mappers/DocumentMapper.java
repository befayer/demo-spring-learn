package com.ssau.learn.mappers;

import com.ssau.learn.dto.DocumentDto;
import com.ssau.learn.entity.Document;
import org.springframework.stereotype.Service;

@Service
public class DocumentMapper {
    public DocumentDto mapToDocumentDto(Document document){
        DocumentDto documentDto = new DocumentDto();
        documentDto.setId(document.getId());
        documentDto.setDateStart(document.getDateStart());
        documentDto.setIssueOrganization(document.getIssueOrganization());
        documentDto.setIssueCode(document.getIssueCode());
        documentDto.setIsActive(document.getIsActive());
        documentDto.setDocumentType(document.getDocumentType());
        return documentDto;
    }

    public Document mapToDocument(DocumentDto documentDto){
        Document document = new Document();
        document.setId(documentDto.getId());
        document.setDateStart(documentDto.getDateStart());
        document.setIssueOrganization(document.getIssueOrganization());
        document.setIssueCode(document.getIssueCode());
        document.setIsActive(document.getIsActive());
        document.setDocumentType(documentDto.getDocumentType());
        return document;
    }
}
