package com.ssau.learn.services;

import com.ssau.learn.DemoApplication;
import com.ssau.learn.dto.BankDto;
import com.ssau.learn.dto.CurrencyDto;
import com.ssau.learn.service.CurrencyService;
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
public class CurrencyServiceTest {

    @Autowired
    private CurrencyService currencyService;

    @Test
    public void testCreate() {
        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setId(1);
        currencyDto.setCurrencyName("Test currency");
        currencyService.save(currencyDto);
        Assertions.assertEquals(currencyService.getCurrency(currencyService.getCurrencyByCurrencyName(currencyDto.getCurrencyName())).getCurrencyName(), currencyDto.getCurrencyName());
    }

    @Test
    public  void testChange(){
        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setId(1);
        currencyDto.setCurrencyName("Test currency");
        currencyService.save(currencyDto);
        currencyDto.setCurrencyName("New test currency");
        currencyService.save(currencyDto);
        Assertions.assertEquals(currencyService.getCurrency(currencyService.getCurrencyByCurrencyName(currencyDto.getCurrencyName())).getCurrencyName(), currencyDto.getCurrencyName());
    }

    @Test
    public  void testDelete(){
        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setId(1);
        currencyDto.setCurrencyName("Test currency");
        currencyService.save(currencyDto);
        currencyDto.setId(2);
        currencyService.save(currencyDto);
        Assertions.assertEquals(2, currencyService.getCurrencies().size());
        currencyService.delete(2);
        Assertions.assertEquals(1, currencyService.getCurrencies().size());
    }
}

