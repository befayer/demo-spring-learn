package com.ssau.learn.service;

import com.ssau.learn.dao.ClientRepository;
import com.ssau.learn.dto.ClientDto;
import com.ssau.learn.entity.Client;
import com.ssau.learn.mappers.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
