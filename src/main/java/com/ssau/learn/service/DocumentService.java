package com.ssau.learn.service;

import com.ssau.learn.dao.DocumentRepository;
import com.ssau.learn.dto.ClientDto;
import com.ssau.learn.dto.DocumentDto;
import com.ssau.learn.entity.Client;
import com.ssau.learn.entity.Document;
import com.ssau.learn.mappers.DocumentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<DocumentDto> getDocuments(){
        List<DocumentDto> documentDtoList = new ArrayList<>();
        List<Document> documents = documentRepository.findAll();
        for (Document document : documents) {
            documentDtoList.add(documentMapper.mapToDocumentDto(document));
        }
        return documentDtoList;
    }

    public DocumentDto save(DocumentDto documentDto) {
        Document document = documentRepository.save(documentMapper.mapToDocument(documentDto));
        return documentMapper.mapToDocumentDto(document);
    }

    public void delete(int id) {
        documentRepository.deleteDocumentById(id);
    }
}
