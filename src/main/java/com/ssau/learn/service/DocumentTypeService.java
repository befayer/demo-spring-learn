package com.ssau.learn.service;

import com.ssau.learn.dao.DocumentTypeRepository;
import com.ssau.learn.dto.DocumentTypeDto;
import com.ssau.learn.entity.DocumentType;
import com.ssau.learn.mappers.DocumentTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentTypeService {
    private final DocumentTypeRepository documentTypeRepository;
    private final DocumentTypeMapper documentTypeMapper;

    public DocumentTypeDto getDocumentType(int id){
        return documentTypeMapper.mapToDocumentTypeDto(
                documentTypeRepository.findDocumentTypeById(id)
                        .orElse(new DocumentType())
        );
    }
}
