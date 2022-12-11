package com.ssau.learn.controller;

import com.ssau.learn.dto.DocumentTypeDto;
import com.ssau.learn.service.DocumentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/document-types")
@RequiredArgsConstructor
public class DocumentTypeController {

    private final DocumentTypeService documentTypeService;

    @GetMapping("/{id}")
    public DocumentTypeDto getDocumentType(@PathVariable int id){return documentTypeService.getDocumentType(id);}

    @GetMapping
    public List<DocumentTypeDto> getDocumentTypes(){
        return documentTypeService.getDocumentTypes();
    }

    @PostMapping()
    //@PreAuthorize("hasRole('ADMIN')")
    public DocumentTypeDto create(@RequestBody DocumentTypeDto documentTypeDto){
        return documentTypeService.save(documentTypeDto);
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public DocumentTypeDto update(@PathVariable int id, @RequestBody DocumentTypeDto documentTypeDto){
        documentTypeDto.setId(id);
        return documentTypeService.save(documentTypeDto);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id){
        documentTypeService.delete(id);
    }

    @GetMapping("/get-bank/{documentTypeName}")
    public int getDocumentTypeByDocumentTypeName(@PathVariable @NonNull String documentTypeName) {
        return documentTypeService.getDocumentTypeByDocumentTypeName(documentTypeName);
    }
}
