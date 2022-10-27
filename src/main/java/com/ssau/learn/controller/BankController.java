package com.ssau.learn.controller;


import com.ssau.learn.dto.BankDto;
import com.ssau.learn.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/url/banks")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;
    @GetMapping
    public List<BankDto> getBanks(){
        return bankService.getBanks();
    }

    @GetMapping("/{id}")
    public BankDto getBank(@PathVariable int id) {
        return bankService.getBank(id);
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public BankDto create(@RequestBody BankDto bankDto){
       return bankService.save(bankDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public BankDto update(@PathVariable int id, @RequestBody BankDto bankDto){
        bankDto.setId(id);
        return bankService.save(bankDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id){
        bankService.delete(id);
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
