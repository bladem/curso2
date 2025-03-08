package com.cursos.curso2.application.clients;

import com.cursos.curso2.model.clients.Client;
import com.cursos.curso2.model.clients.ports.ClientRepositoryPort;
import com.cursos.curso2.model.clients.ports.ClientServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientServicePort {

    private final ClientRepositoryPort clientRepositoryPort;


    @Override
    public Client createClient(String name, String lastName, String email, String phone) {
        return clientRepositoryPort.createClient(name, lastName, email, phone);
    }

    @Override
    public Client updateClient(Long id, String name, String lastName, String email, String phone) {
        return null;
    }

    @Override
    public void deleteClient(Long id) {

    }

    @Override
    public Client getClient(String name) {
        return null;
    }

    @Override
    public Client getClient(Long id) {
        return null;
    }
}
