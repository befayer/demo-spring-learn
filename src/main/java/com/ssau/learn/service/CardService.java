package com.ssau.learn.service;

import com.ssau.learn.dao.CardRepository;
import com.ssau.learn.dto.BankDto;
import com.ssau.learn.dto.CardDto;
import com.ssau.learn.entity.Bank;
import com.ssau.learn.entity.Card;
import com.ssau.learn.mappers.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardDto getCard(int id){
        return cardMapper.mapToCardDto(
                cardRepository.findCardById(id)
                        .orElse(new Card())
        );
    }

    public List<CardDto> getCards(){
        List<CardDto> cardDtoList = new ArrayList<>();
        List<Card> cards = cardRepository.findAll();
        for (Card card : cards) {
            cardDtoList.add(cardMapper.mapToCardDto(card));
        }
        return cardDtoList;
    }

    public CardDto save(CardDto cardDto) {
        Card card = cardRepository.save(cardMapper.mapToCard(cardDto));
        return cardMapper.mapToCardDto(card);
    }

    public void delete(int id) {
        cardRepository.deleteCardById(id);
    }
}
