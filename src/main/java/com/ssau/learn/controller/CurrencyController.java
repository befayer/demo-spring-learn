package com.ssau.learn.controller;


import com.ssau.learn.dto.CurrencyDto;
import com.ssau.learn.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    public List<CurrencyDto> getCurrencies(){
        return currencyService.getCurrencies();
    }

    @GetMapping("/{id}")
    public CurrencyDto getCurrency(@PathVariable int id) {
        return currencyService.getCurrency(id);
    }

    @PostMapping()
    //@PreAuthorize("hasRole('ADMIN')")
    public CurrencyDto create(@RequestBody CurrencyDto currencyDto){
       return currencyService.save(currencyDto);
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public CurrencyDto update(@PathVariable int id, @RequestBody CurrencyDto currencyDto){
        currencyDto.setId(id);
        return currencyService.save(currencyDto);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id){
        currencyService.delete(id);
    }

}
