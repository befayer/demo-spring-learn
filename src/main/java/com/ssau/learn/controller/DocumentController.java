package com.ssau.learn.controller;

import com.ssau.learn.dto.DocumentDto;
import com.ssau.learn.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/url/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping("/{id}")
    public DocumentDto getDocument(@PathVariable int id){return documentService.getDocument(id);}

    @GetMapping
    public List<DocumentDto> getDocuments(){
        return documentService.getDocuments();
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public DocumentDto create(@RequestBody DocumentDto documentDto){
        return documentService.save(documentDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public DocumentDto update(@PathVariable int id, @RequestBody DocumentDto documentDto){
        documentDto.setId(id);
        return documentService.save(documentDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id){
        documentService.delete(id);
    }
}
