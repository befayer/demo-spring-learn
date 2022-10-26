package com.ssau.learn.controller;

import com.ssau.learn.dto.CardDto;
import com.ssau.learn.dto.ClientDto;
import com.ssau.learn.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/url/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable int id){return clientService.getClient(id);}

    @GetMapping
    public List<ClientDto> getClients(@RequestParam(required = false) String name){
        return clientService.getClients(name);
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ClientDto create(@RequestBody ClientDto clientDto){
        return clientService.save(clientDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ClientDto update(@PathVariable int id, @RequestBody ClientDto clientDto){
        clientDto.setId(id);
        return clientService.save(clientDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id){
        clientService.delete(id);
    }
}
