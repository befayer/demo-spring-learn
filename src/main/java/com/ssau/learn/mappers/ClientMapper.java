package com.ssau.learn.mappers;

import com.ssau.learn.dto.ClientDto;
import com.ssau.learn.entity.Client;
import com.ssau.learn.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClientMapper {

    @Autowired
    private DocumentMapper documentMapper;

    public ClientDto mapToClientDto(Client client){
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setSecondName(client.getSecondName());
        clientDto.setPatronymic(client.getPatronymic());
        clientDto.setBirthday(client.getBirthday());
        for (int i = 0; i < client.getDocuments().size(); i++) {
            clientDto.setDocument(documentMapper.mapToDocumentDto(client.getDocuments().get(i)));
        }
        return clientDto;
    }

    public Client mapToClient(ClientDto clientDto){
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setFirstName(clientDto.getFirstName());
        client.setSecondName(clientDto.getSecondName());
        client.setPatronymic(clientDto.getPatronymic());
        client.setBirthday(clientDto.getBirthday());
        for (int i = 0; i < clientDto.getDocuments().size(); i++) {
            client.setDocument(documentMapper.mapToDocument(clientDto.getDocuments().get(i)));
        }
        return client;
    }
}
