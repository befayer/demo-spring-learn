package com.ssau.learn.controller;

import com.ssau.learn.dto.DocumentTypeDto;
import com.ssau.learn.service.DocumentTypeService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DocumentTypeControllerTest {

    @Test
    public void testCreate(){
        DocumentTypeService documentTypeService = mock(DocumentTypeService.class);
        DocumentTypeDto documentTypeDto = new DocumentTypeDto();
        documentTypeDto.setDocumentTypeName("Test document type name");
        documentTypeDto.setId(1);
        when(documentTypeService.save(any(DocumentTypeDto.class))).thenReturn(documentTypeDto);

        DocumentTypeController documentTypeController = new DocumentTypeController(documentTypeService);
        DocumentTypeDto documentTypeDto1 = new DocumentTypeDto();
        documentTypeDto1.setDocumentTypeName("Test document type name");
        documentTypeDto1 = documentTypeController.create(documentTypeDto1);
        Assertions.assertEquals("Test document type name", documentTypeDto1.getDocumentTypeName());
        Assertions.assertEquals(1L, documentTypeDto1.getId().longValue());
    }
}
