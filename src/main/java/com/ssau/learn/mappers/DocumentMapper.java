package com.ssau.learn.mappers;

import com.ssau.learn.dto.DocumentDto;
import com.ssau.learn.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentMapper {

    @Autowired
    private DocumentTypeMapper documentTypeMapper;

    public DocumentDto mapToDocumentDto(Document document){
        DocumentDto documentDto = new DocumentDto();
        documentDto.setId(document.getId());
        documentDto.setDateStart(document.getDateStart());
        documentDto.setIssueOrganization(document.getIssueOrganization());
        documentDto.setIsActive(document.getIsActive());
        documentDto.setDocumentType(documentTypeMapper.mapToDocumentTypeDto(document.getDocumentType()));
        return documentDto;
    }

    public Document mapToDocument(DocumentDto documentDto){
        Document document = new Document();
        document.setId(documentDto.getId());
        document.setDateStart(documentDto.getDateStart());
        document.setIssueOrganization(documentDto.getIssueOrganization());
        document.setIsActive(documentDto.getIsActive());
        document.setDocumentType(documentTypeMapper.mapToDocumentType(documentDto.getDocumentType()));
        return document;
    }
}
