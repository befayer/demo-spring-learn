package com.ssau.learn.controller;

import com.ssau.learn.dto.BankDto;
import com.ssau.learn.service.BankServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/url/banks")
@RequiredArgsConstructor
public class BankController {
    private final BankServiceImpl bankService;

    @GetMapping("/{id}")
    public BankDto getBank(@PathVariable int id) {
        return bankService.getBank(id);
    }

    @GetMapping("/get-bank/{bik}")
    public int getBankByBik(@PathVariable @NonNull String bik) {
        return bankService.getBankByBik(bik);
    }

    @GetMapping("/get-bank/{terbankName}")
    public int getBankByTerbankName(@PathVariable @NonNull String terbankName) {
        return bankService.getBankByTerbankName(terbankName);
    }

}
