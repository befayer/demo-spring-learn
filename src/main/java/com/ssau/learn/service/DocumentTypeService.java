package com.ssau.learn.service;

import com.ssau.learn.dao.DocumentTypeRepository;
import com.ssau.learn.dto.DocumentTypeDto;
import com.ssau.learn.entity.DocumentType;
import com.ssau.learn.mappers.DocumentTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentTypeService {
    private final DocumentTypeRepository documentTypeRepository;
    private final DocumentTypeMapper documentTypeMapper;

    public DocumentTypeDto getDocumentType(int id) {
        return documentTypeMapper.mapToDocumentTypeDto(documentTypeRepository.findDocumentTypeById(id).orElseThrow());
    }

    public List<DocumentTypeDto> getDocumentTypes() {
        List<DocumentTypeDto> documentTypeDtoList = new ArrayList<>();
        List<DocumentType> documentTypes = documentTypeRepository.findAll();
        for (DocumentType documentType : documentTypes) {
            documentTypeDtoList.add(documentTypeMapper.mapToDocumentTypeDto(documentType));
        }
        return documentTypeDtoList;
    }

    public DocumentTypeDto save(DocumentTypeDto documentTypeDto) {
        DocumentType documentType = documentTypeRepository.save(documentTypeMapper.mapToDocumentType(documentTypeDto));
        return documentTypeMapper.mapToDocumentTypeDto(documentType);
    }

    public void delete(int id) {
        documentTypeRepository.deleteDocumentTypeById(id);
    }

    public int getDocumentTypeByDocumentTypeName(String documentTypeName) {
        DocumentType documentType = documentTypeRepository.getDocumentTypeByDocumentTypeName(documentTypeName).orElseThrow();
        return documentType.getId();
    }
}
