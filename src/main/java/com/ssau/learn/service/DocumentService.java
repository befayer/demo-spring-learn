package com.ssau.learn.service;

import com.ssau.learn.dao.DocumentRepository;
import com.ssau.learn.dto.DocumentDto;
import com.ssau.learn.entity.Document;
import com.ssau.learn.mappers.DocumentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    public DocumentDto getDocument(int id){
        return documentMapper.mapToDocumentDto(
                documentRepository.findDocumentById(id)
                        .orElse(new Document())
        );
    }
}
