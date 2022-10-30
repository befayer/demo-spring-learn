package com.ssau.learn.services;

import com.ssau.learn.DemoApplication;
import com.ssau.learn.dto.*;
import com.ssau.learn.mappers.ClientMapper;
import com.ssau.learn.service.*;
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
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private DocumentTypeService documentTypeService;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private BankService bankService;

    @Autowired
    private CurrencyService currencyService;

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

        BankDto bankDto = new BankDto();
        bankDto.setId(1);
        bankDto.setTerbankName("Test bank");
        bankDto.setBik("Test bik");
        bankDto.setCity("Test city");
        bankService.save(bankDto);

        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setId(1);
        currencyDto.setCurrencyName("Test currency");
        currencyService.save(currencyDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setId(1);
        accountDto.setClient(clientMapper.mapToClient(clientDto));
        accountDto.setAccountStatus(true);
        accountDto.setBalance(0.0);
        accountDto.setBank(bankDto);
        accountDto.setCurrency(currencyDto);
        accountService.save(accountDto);
        Assertions.assertEquals(accountService.getAccount(1).getId(), accountDto.getId());
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

        BankDto bankDto = new BankDto();
        bankDto.setId(1);
        bankDto.setTerbankName("Test bank");
        bankDto.setBik("Test bik");
        bankDto.setCity("Test city");
        bankService.save(bankDto);

        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setId(1);
        currencyDto.setCurrencyName("Test currency");
        currencyService.save(currencyDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setId(1);
        accountDto.setClient(clientMapper.mapToClient(clientDto));
        accountDto.setAccountStatus(true);
        accountDto.setBalance(0.0);
        accountDto.setBank(bankDto);
        accountDto.setCurrency(currencyDto);
        accountService.save(accountDto);
        accountDto.setAccountStatus(false);
        accountService.save(accountDto);
        Assertions.assertEquals(accountService.getAccount(1).getAccountStatus(), accountDto.getAccountStatus());
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

        ClientDto clientDto1 = new ClientDto();
        clientDto1.setId(2);
        clientDto1.setFirstName("Test first name");
        clientDto1.setSecondName("Test second name");
        clientDto1.setPatronymic("Test patronymic");
        clientDto1.setBirthday(LocalDate.now());
        clientDto1.addDocument(documentDto);
        clientService.save(clientDto1);

        BankDto bankDto = new BankDto();
        bankDto.setId(1);
        bankDto.setTerbankName("Test bank");
        bankDto.setBik("Test bik");
        bankDto.setCity("Test city");
        bankService.save(bankDto);

        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setId(1);
        currencyDto.setCurrencyName("Test currency");
        currencyService.save(currencyDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setId(1);
        accountDto.setClient(clientMapper.mapToClient(clientDto));
        accountDto.setAccountStatus(true);
        accountDto.setBalance(0.0);
        accountDto.setBank(bankDto);
        accountDto.setCurrency(currencyDto);
        accountService.save(accountDto);

        AccountDto accountDto1 = new AccountDto();
        accountDto1.setId(2);
        accountDto1.setClient(clientMapper.mapToClient(clientDto1));
        accountDto1.setAccountStatus(true);
        accountDto1.setBalance(0.0);
        accountDto1.setBank(bankDto);
        accountDto1.setCurrency(currencyDto);

        accountService.save(accountDto1);

        Assertions.assertEquals(2, accountService.getAccounts().size());
        accountService.delete(2);
        Assertions.assertEquals(1, accountService.getAccounts().size());
    }
}

