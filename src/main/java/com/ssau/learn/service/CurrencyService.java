package com.ssau.learn.service;

import com.ssau.learn.dao.CurrencyRepository;
import com.ssau.learn.dto.CurrencyDto;
import com.ssau.learn.entity.Bank;
import com.ssau.learn.entity.Currency;
import com.ssau.learn.mappers.CurrencyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    public CurrencyDto getCurrency(int id) {
        return currencyMapper.mapToCurrencyDto(
                currencyRepository.findById(id)
                        .orElse(new Currency())
        );
    }

    public List<CurrencyDto> getCurrencies(){
        List<CurrencyDto> currencyDtoList = new ArrayList<>();
        List<Currency> currencies = currencyRepository.findAll();
        for (Currency currency : currencies) {
            currencyDtoList.add(currencyMapper.mapToCurrencyDto(currency));
        }
        return currencyDtoList;
    }

    public CurrencyDto save(CurrencyDto currencyDto) {
        Currency currency = currencyRepository.save(currencyMapper.mapToCurrency(currencyDto));
        return currencyMapper.mapToCurrencyDto(currency);
    }

    public void delete(int id) {
        currencyRepository.deleteCurrencyById(id);
    }

    public int getCurrencyByCurrencyName(String currencyName) {
        Currency currency = currencyRepository.findCurrencyByCurrencyName(currencyName).orElseThrow();
        return currency.getId();
    }

}
