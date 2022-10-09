package com.ssau.learn.mappers;

import com.ssau.learn.dto.DocumentTypeDto;
import com.ssau.learn.entity.DocumentType;
import org.springframework.stereotype.Service;

@Service
public class DocumentTypeMapper {

    public DocumentTypeDto mapToDocumentTypeDto(DocumentType documentType){
        DocumentTypeDto documentTypeDto = new DocumentTypeDto();
        documentTypeDto.setId(documentType.getId());
        documentTypeDto.setDocumentTypeName(documentType.getDocumentTypeName());
        documentTypeDto.setDocumentList(documentType.getDocumentList());
        return documentTypeDto;
    }

    public DocumentType mapToDocumentType(DocumentType documentTypeDto){
        DocumentType documentType = new DocumentType();
        documentType.setId(documentTypeDto.getId());
        documentType.setDocumentTypeName(documentType.getDocumentTypeName());
        documentType.setDocumentList(documentType.getDocumentList());
        return documentType;
    }

}
