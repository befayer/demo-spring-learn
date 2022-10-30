package com.ssau.learn.services;

import com.ssau.learn.DemoApplication;
import com.ssau.learn.dto.ClientDto;
import com.ssau.learn.dto.DocumentDto;
import com.ssau.learn.dto.DocumentTypeDto;
import com.ssau.learn.mappers.DocumentTypeMapper;
import com.ssau.learn.service.ClientService;
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

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest(classes = DemoApplication.class)
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private DocumentTypeService documentTypeService;

    @Autowired
    private DocumentTypeMapper documentTypeMapper;

    @Test
    public void testCreate() {
        DocumentTypeDto documentTypeDto = new DocumentTypeDto();
        documentTypeDto.setId(1);
        documentTypeDto.setDocumentTypeName("Test document type");
        documentTypeService.save(documentTypeDto);

        DocumentDto documentDto = new DocumentDto();
        documentDto.setId(1);
        documentDto.setDateStart(LocalDate.now());
        documentDto.setIssueOrganization("Test issue organization");
        documentDto.setIsActive(true);
        documentDto.setDocumentTypeDto(documentTypeDto);
        documentService.save(documentDto);

        ClientDto clientDto = new ClientDto();
        clientDto.setId(1);
        clientDto.setFirstName("Test first name");
        clientDto.setSecondName("Test second name");
        clientDto.setPatronymic("Test patronymic");
        clientDto.setBirthday(LocalDate.now());
        clientDto.addDocument(documentDto);
        clientService.save(clientDto);
        Assertions.assertEquals(clientService.getClient(clientDto.getId()).getFirstName(), clientDto.getFirstName());
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
        documentDto.setDocumentTypeDto(documentTypeDto);
        documentService.save(documentDto);

        ClientDto clientDto = new ClientDto();
        clientDto.setId(1);
        clientDto.setFirstName("Test first name");
        clientDto.setSecondName("Test second name");
        clientDto.setPatronymic("Test patronymic");
        clientDto.setBirthday(LocalDate.now());
        clientDto.addDocument(documentDto);
        clientService.save(clientDto);
        clientDto.setFirstName("New test first name");
        clientService.save(clientDto);
        Assertions.assertEquals(clientService.getClient(clientDto.getId()).getFirstName(), clientDto.getFirstName());
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
        documentDto.setDocumentTypeDto(documentTypeDto);
        documentService.save(documentDto);

        ClientDto clientDto = new ClientDto();
        clientDto.setId(1);
        clientDto.setFirstName("Test first name");
        clientDto.setSecondName("Test second name");
        clientDto.setPatronymic("Test patronymic");
        clientDto.setBirthday(LocalDate.now());
        clientDto.addDocument(documentDto);
        clientService.save(clientDto);
        clientDto.setId(2);
        clientService.save(clientDto);
        Assertions.assertEquals(2, clientService.getClients().size());
        clientService.delete(1);
        Assertions.assertEquals(1, clientService.getClients().size());
    }
}

