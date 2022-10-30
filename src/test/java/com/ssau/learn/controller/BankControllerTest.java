package com.ssau.learn.controller;

import com.ssau.learn.dto.BankDto;
import com.ssau.learn.service.BankService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankControllerTest {

    @Test
    public void testCreate(){
        BankService bankService = mock(BankService.class);
        BankDto testBank = new BankDto();
        testBank.setTerbankName("Test bank");
        testBank.setId(1);
        when(bankService.save(any(BankDto.class))).thenReturn(testBank);

        BankController bankController = new BankController(bankService);
        BankDto bankDto = new BankDto();
        bankDto.setTerbankName("Test bank");
        bankDto = bankController.create(bankDto);
        Assertions.assertEquals("Test bank", bankDto.getTerbankName());
        Assertions.assertEquals(1L, bankDto.getId().longValue());
    }
}
