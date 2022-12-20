package com.ssau.learn.services;

import com.ssau.learn.DemoApplication;
import com.ssau.learn.dto.*;
import com.ssau.learn.mappers.*;
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
public class CardServiceTest {

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

    @Autowired
    private CardService cardService;

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
        documentDto.setDocumentType(documentTypeDto);
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

        CardDto cardDto = new CardDto();
        cardDto.setId(1);
        cardDto.setDateStart(LocalDate.now());
        cardDto.setDateEnd(LocalDate.now());
        cardDto.setCvc(535);
        cardDto.setStatus(true);
        cardDto.setBalance(0.0);
        cardDto.setAccount(accountDto);
        cardService.save(cardDto);
        Assertions.assertEquals(cardService.getCard(1).getId(), accountDto.getId());
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

        CardDto cardDto = new CardDto();
        cardDto.setId(1);
        cardDto.setDateStart(LocalDate.now());
        cardDto.setDateEnd(LocalDate.now());
        cardDto.setCvc(535);
        cardDto.setStatus(true);
        cardDto.setBalance(0.0);
        cardDto.setAccount(accountDto);
        cardService.save(cardDto);
        cardDto.setStatus(false);
        cardService.save(cardDto);
        Assertions.assertEquals(cardService.getCard(1).getAccountStatus(), cardDto.getAccountStatus());
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

        CardDto cardDto = new CardDto();
        cardDto.setId(1);
        cardDto.setDateStart(LocalDate.now());
        cardDto.setDateEnd(LocalDate.now());
        cardDto.setCvc(535);
        cardDto.setStatus(true);
        cardDto.setBalance(0.0);
        cardDto.setAccount(accountDto);
        cardService.save(cardDto);

        cardDto.setId(2);
        cardService.save(cardDto);

        Assertions.assertEquals(2, cardService.getCards().size());
        cardService.delete(2);
        Assertions.assertEquals(1, cardService.getCards().size());
    }
}

