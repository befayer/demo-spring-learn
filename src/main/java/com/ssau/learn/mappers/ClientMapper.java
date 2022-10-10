package com.ssau.learn.mappers;

import com.ssau.learn.dto.ClientDto;
import com.ssau.learn.entity.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {

    public ClientDto mapToClientDto(Client client){
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setSecondName(client.getSecondName());
        clientDto.setPatronymic(client.getPatronymic());
        clientDto.setBirthday(client.getBirthday());
        return clientDto;
    }

    public Client mapToClient(ClientDto clientDto){
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setFirstName(clientDto.getFirstName());
        client.setSecondName(clientDto.getSecondName());
        client.setPatronymic(clientDto.getPatronymic());
        client.setBirthday(clientDto.getBirthday());
        return client;
    }
}
