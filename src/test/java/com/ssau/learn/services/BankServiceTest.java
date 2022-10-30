package com.ssau.learn.services;

import com.ssau.learn.DemoApplication;
import com.ssau.learn.dto.BankDto;
import com.ssau.learn.service.BankService;
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
public class BankServiceTest {

    @Autowired
    private BankService bankService;

    @Test
    public void testCreate() {
        BankDto bankDto = new BankDto();
        bankDto.setId(1);
        bankDto.setTerbankName("Test bank");
        bankDto.setBik("Test bik");
        bankDto.setCity("Test city");
        bankService.save(bankDto);
        Assertions.assertEquals(bankService.getBank(bankService.getBankByTerbankName
                (bankDto.getTerbankName())).getTerbankName(), bankDto.getTerbankName());
    }

    @Test
    public void testChange() {
        BankDto bankDto = new BankDto();
        bankDto.setId(1);
        bankDto.setTerbankName("Test bank");
        bankDto.setBik("Test bik");
        bankDto.setCity("Test city");
        bankDto = bankService.save(bankDto);
        bankDto.setTerbankName("New terbank name");
        bankDto.setBik("New terbank bik");
        bankDto.setCity("New terbank city");
        bankService.save(bankDto);
        Assertions.assertEquals(bankService.getBank(bankService.getBankByTerbankName
                (bankDto.getTerbankName())).getTerbankName(), bankDto.getTerbankName());
    }

    @Test
    public void testDelete() {
        BankDto bankDto = new BankDto();
        bankDto.setId(1);
        bankDto.setTerbankName("Test bank");
        bankDto.setBik("Test bik");
        bankDto.setCity("Test city");
        bankService.save(bankDto);
        bankDto.setId(2);
        bankService.save(bankDto);
        Assertions.assertEquals(2, bankService.getBanks().size());
        bankService.delete(1);
        Assertions.assertEquals(1, bankService.getBanks().size());
    }
}

