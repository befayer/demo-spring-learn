package com.ssau.learn.mappers;

import com.ssau.learn.dto.ClientDto;
import com.ssau.learn.entity.Account;
import com.ssau.learn.entity.Client;
import com.ssau.learn.entity.ClientDocument;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClientMapper {

    public ClientDto mapToClientDto(Client client){
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setSecondName(client.getSecondName());
        clientDto.setPatronymic(client.getPatronymic());
        clientDto.setBirthday(client.getBirthday());
        clientDto.setClientDocumentList(client.getClientDocumentList());
        clientDto.setAccountList(client.getAccountList());
        return clientDto;
    }

    public Client mapToClient(ClientDto clientDto){
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setFirstName(clientDto.getFirstName());
        client.setSecondName(clientDto.getSecondName());
        client.setPatronymic(clientDto.getPatronymic());
        client.setBirthday(clientDto.getBirthday());
        client.setClientDocumentList(clientDto.getClientDocumentList());
        client.setAccountList(clientDto.getAccountList());
        return client;
    }
}
