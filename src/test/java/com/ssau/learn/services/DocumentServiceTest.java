package com.ssau.learn.services;

import com.ssau.learn.DemoApplication;
import com.ssau.learn.dto.DocumentDto;
import com.ssau.learn.dto.DocumentTypeDto;
import com.ssau.learn.service.DocumentService;
import com.ssau.learn.service.DocumentTypeService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest(classes = DemoApplication.class)
public class DocumentServiceTest {

    @Autowired
    private DocumentService documentService;

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

        DocumentDto documentDto = new DocumentDto();
        documentDto.setId(1);
        documentDto.setDateStart(LocalDate.now());
        documentDto.setIssueOrganization("Test issue organization");
        documentDto.setIsActive(true);
        documentDto.setDocumentType(documentTypeDto);
        documentService.save(documentDto);
        Assertions.assertEquals(documentService.getDocument(documentDto.getId()).getId(), documentDto.getId());
    }

    @Test
    public void testChange() {
        DocumentTypeDto documentTypeDto = new DocumentTypeDto();
        documentTypeDto.setId(1);
        documentTypeDto.setDocumentTypeName("Test document type");
        documentTypeService.save(documentTypeDto);

        DocumentDto documentDto = new DocumentDto();
        documentDto.setId(1);
        documentDto.setDateStart(LocalDate.now());
        documentDto.setIssueOrganization("Test issue organization");
        documentDto.setIsActive(true);
        documentDto.setDocumentType(documentTypeDto);
        documentService.save(documentDto);

        documentDto.setId(2);
        documentDto.setIssueOrganization("New test issue organization");
        documentDto.setIsActive(false);
        documentService.save(documentDto);
        Assertions.assertEquals(documentService.getDocument(documentDto.getId()).getId(), documentDto.getId());
    }

    @Test
    public void testDelete() {
        DocumentTypeDto documentTypeDto = new DocumentTypeDto();
        documentTypeDto.setId(1);
        documentTypeDto.setDocumentTypeName("Test document type");
        documentTypeService.save(documentTypeDto);

        DocumentDto documentDto = new DocumentDto();
        documentDto.setId(1);
        documentDto.setDateStart(LocalDate.now());
        documentDto.setIssueOrganization("Test issue organization");
        documentDto.setIsActive(true);
        documentDto.setDocumentType(documentTypeDto);
        documentService.save(documentDto);

        documentDto.setId(2);
        documentDto.setIssueOrganization("New test issue organization");
        documentDto.setIsActive(false);
        documentService.save(documentDto);

        documentDto.setId(2);
        documentService.save(documentDto);
        Assertions.assertEquals(2, documentService.getDocuments().size());
        documentService.delete(1);
        Assertions.assertEquals(1, documentService.getDocuments().size());
    }
}

