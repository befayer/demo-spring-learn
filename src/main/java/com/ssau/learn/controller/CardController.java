package com.ssau.learn.controller;

import com.ssau.learn.dto.CardDto;
import com.ssau.learn.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/url/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/{id}")
    public CardDto getCard(@PathVariable int id){return cardService.getCard(id);}

    @GetMapping
    public List<CardDto> getCards(){
        return cardService.getCards();
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public CardDto create(@RequestBody CardDto cardDto){
        return cardService.save(cardDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public CardDto update(@PathVariable int id, @RequestBody CardDto cardDto){
        cardDto.setId(id);
        return cardService.save(cardDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id){
        cardService.delete(id);
    }
}
