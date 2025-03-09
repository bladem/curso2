package com.cursos.curso2.application.clients;

import com.cursos.curso2.model.clients.Client;
import com.cursos.curso2.model.clients.ports.ClientRepositoryPort;
import com.cursos.curso2.model.clients.ports.ClientServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return clientRepositoryPort.updateClient(id, name, lastName, email, phone);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepositoryPort.deleteClient(id);
    }

    @Override
    public Client getClient(String name) {
        return clientRepositoryPort.getClient(name);
    }

    @Override
    public Client getClient(Long id) {
        return clientRepositoryPort.getClient(id);
    }

    @Override
    public List<Client> getClients() {
        return List.of();
    }
}
