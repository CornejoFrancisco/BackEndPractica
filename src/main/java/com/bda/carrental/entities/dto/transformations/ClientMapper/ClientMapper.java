package com.bda.carrental.entities.dto.transformations.ClientMapper;

import com.bda.carrental.entities.Client;

import com.bda.carrental.entities.dto.ClientDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ClientMapper implements Function<ClientDto, Client> {
    @Override
    public Client apply(ClientDto clientDto) {
        return new Client(
                clientDto.getId(),
                clientDto.getFirstName(),
                clientDto.getLastName(),
                clientDto.getSex(),
                clientDto.getBirthDate(),
                null,
                null);
    }
}
