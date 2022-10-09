package com.ssau.learn.mappers;

import com.ssau.learn.dto.BankDto;
import com.ssau.learn.dto.CardDto;
import com.ssau.learn.entity.Bank;
import com.ssau.learn.entity.Card;
import org.springframework.stereotype.Service;

@Service
public class CardMapper {

    public CardDto mapToCardDto(Card card){
        CardDto cardDto = new CardDto();
        cardDto.setId(card.getId());
        cardDto.setAccountNumber(card.getAccountNumber());
        cardDto.setDateStart(card.getDateStart());
        cardDto.setDateEnd(card.getDateEnd());
        cardDto.setCvc(card.getCvc());
        cardDto.setBalance(card.getBalance());
        return cardDto;
    }

    public Card mapToCard(CardDto cardDto){
        Card card = new Card();
        card.setId(cardDto.getId());
        card.setAccountNumber(cardDto.getAccountNumber());
        card.setDateStart(cardDto.getDateStart());
        card.setDateEnd(cardDto.getDateEnd());
        card.setCvc(card.getCvc());
        card.setBalance(card.getBalance());
        return card;
    }
}
