package com.ssau.learn.service;

import com.ssau.learn.dao.CardRepository;
import com.ssau.learn.dto.CardDto;
import com.ssau.learn.entity.Card;
import com.ssau.learn.mappers.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
