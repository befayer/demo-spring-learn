package com.ssau.learn.controller;

import com.ssau.learn.dto.AccountDto;
import com.ssau.learn.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/url/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public AccountDto getAccount(@PathVariable int id){return accountService.getAccount(id);}

    @GetMapping
    public List<AccountDto> getAccounts(){
        return accountService.getAccounts();
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public AccountDto create(@RequestBody AccountDto accountDto){
        return accountService.save(accountDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public AccountDto update(@PathVariable int id, @RequestBody AccountDto accountDto){
        accountDto.setId(id);
        return accountService.save(accountDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id){
        accountService.delete(id);
    }
}
