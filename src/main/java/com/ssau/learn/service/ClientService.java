package com.ssau.learn.service;

import com.ssau.learn.dao.ClientRepository;
import com.ssau.learn.dto.CardDto;
import com.ssau.learn.dto.ClientDto;
import com.ssau.learn.entity.Card;
import com.ssau.learn.entity.Client;
import com.ssau.learn.mappers.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientDto getClient(int id){
        return clientMapper.mapToClientDto(
                clientRepository.findClientById(id)
                        .orElse(new Client())
        );
    }

    public List<ClientDto> getClients(){
        List<ClientDto> clientDtoList = new ArrayList<>();
        List<Client> clients = clientRepository.findAll();
        for (Client client : clients) {
            clientDtoList.add(clientMapper.mapToClientDto(client));
        }
        return clientDtoList;
    }

    public ClientDto save(ClientDto clientDto) {
        Client client = clientRepository.save(clientMapper.mapToClient(clientDto));
        return clientMapper.mapToClientDto(client);
    }

    public void delete(int id) {
        clientRepository.deleteClientById(id);
    }
}
