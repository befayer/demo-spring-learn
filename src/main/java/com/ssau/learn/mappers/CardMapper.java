package com.ssau.learn.mappers;

import com.ssau.learn.dto.CardDto;
import com.ssau.learn.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardMapper {

    @Autowired
    private AccountMapper accountMapper;

    public CardDto mapToCardDto(Card card){
        CardDto cardDto = new CardDto();
        cardDto.setId(card.getId());
        cardDto.setAccount(accountMapper.mapToAccountDto(card.getAccountNumber()));
        cardDto.setDateStart(card.getDateStart());
        cardDto.setDateEnd(card.getDateEnd());
        cardDto.setCvc(card.getCvc());
        cardDto.setBalance(card.getBalance());
        return cardDto;
    }

    public Card mapToCard(CardDto cardDto){
        Card card = new Card();
        card.setId(cardDto.getId());
        card.setAccountNumber(accountMapper.mapToAccount(cardDto.getAccount()));
        card.setDateStart(cardDto.getDateStart());
        card.setDateEnd(cardDto.getDateEnd());
        card.setCvc(cardDto.getCvc());
        card.setBalance(cardDto.getBalance());
        return card;
    }
}
