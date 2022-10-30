package com.ssau.learn.services;

import com.ssau.learn.DemoApplication;
import com.ssau.learn.dto.DocumentTypeDto;
import com.ssau.learn.service.DocumentTypeService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest(classes = DemoApplication.class)
public class DocumentTypeServiceTest {

    @Autowired
    private DocumentTypeService documentTypeService;

    @Test
    public void testCreate() {
        DocumentTypeDto documentTypeDto = new DocumentTypeDto();
        documentTypeDto.setId(1);
        documentTypeDto.setDocumentTypeName("Test document type");
        documentTypeService.save(documentTypeDto);
        Assertions.assertEquals(documentTypeService.getDocumentType
                                (documentTypeService.getDocumentTypeByDocumentTypeName(documentTypeDto.getDocumentTypeName())).
                        getDocumentTypeName(),
                documentTypeDto.getDocumentTypeName());
    }

    @Test
    public void testChange() {
        DocumentTypeDto documentTypeDto = new DocumentTypeDto();
        documentTypeDto.setId(1);
        documentTypeDto.setDocumentTypeName("Test document type");
        documentTypeService.save(documentTypeDto);

        documentTypeDto.setDocumentTypeName("Test document type");
        documentTypeService.save(documentTypeDto);
        Assertions.assertEquals(documentTypeService.getDocumentType
                (documentTypeService.getDocumentTypeByDocumentTypeName
                        (documentTypeDto.getDocumentTypeName())).getDocumentTypeName(), documentTypeDto.getDocumentTypeName());
    }

    @Test
    public void testDelete() {
        DocumentTypeDto documentTypeDto = new DocumentTypeDto();
        documentTypeDto.setId(1);
        documentTypeDto.setDocumentTypeName("Test document type");
        documentTypeService.save(documentTypeDto);
        documentTypeDto.setId(2);
        documentTypeService.save(documentTypeDto);
        Assertions.assertEquals(2, documentTypeService.getDocumentTypes().size());
        documentTypeService.delete(1);
        Assertions.assertEquals(1, documentTypeService.getDocumentTypes().size());
    }
}

