package com.ssau.learn.controller;

import com.ssau.learn.dto.DocumentDto;
import com.ssau.learn.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/url/documents")
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;

    @GetMapping("/{id}")
    public DocumentDto getDocument(@PathVariable int id){
        return documentService.getDocument(id);
    }
}
