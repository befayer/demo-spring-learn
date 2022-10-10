package com.ssau.learn.controller;

import com.ssau.learn.dto.DocumentTypeDto;
import com.ssau.learn.service.DocumentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/url/document_types")
@RequiredArgsConstructor
public class DocumentTypeController {
    private final DocumentTypeService documentTypeService;

    @GetMapping("/{id}")
    public DocumentTypeDto getDocumentType(@PathVariable int id){
        return documentTypeService.getDocumentType(id);
    }
}
