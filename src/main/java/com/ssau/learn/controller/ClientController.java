package com.ssau.learn.controller;

import com.ssau.learn.dto.ClientDto;
import com.ssau.learn.dto.DocumentDto;
import com.ssau.learn.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable int id){return clientService.getClient(id);}

    @GetMapping
    public List<ClientDto> getClients(){
        return clientService.getClients();
    }

    @PostMapping("/get-client-by-doc")
    public List<ClientDto> getDocumentsByClient(DocumentDto documentDto){
        return clientService.getClientByDocument(documentDto);
    }

    @PostMapping()
    //@PreAuthorize("hasRole('ADMIN')")
    public ClientDto create(@RequestBody ClientDto clientDto){
        return clientService.save(clientDto);
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ClientDto update(@PathVariable int id, @RequestBody ClientDto clientDto){
        clientDto.setId(id);
        return clientService.save(clientDto);
    }

    @DeleteMapping("/{id}")
   // @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id){
        clientService.delete(id);
    }
}
