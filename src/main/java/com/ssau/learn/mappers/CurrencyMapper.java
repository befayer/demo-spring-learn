package com.ssau.learn.mappers;

import com.ssau.learn.dto.CurrencyDto;
import com.ssau.learn.entity.Currency;
import org.springframework.stereotype.Service;


@Service
public class CurrencyMapper {
    public CurrencyDto mapToCurrencyDto(Currency currency){
        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setId(currency.getId());
        currencyDto.setCurrencyName(currency.getCurrencyName());
        return currencyDto;
    }

    public Currency mapToCurrency(CurrencyDto currencyDto){
        Currency currency = new Currency();
        currency.setId(currencyDto.getId());
        currency.setCurrencyName(currencyDto.getCurrencyName());
        return currency;
    }
}
