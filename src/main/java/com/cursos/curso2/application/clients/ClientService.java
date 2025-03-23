package com.cursos.curso2.application.clients;

import com.cursos.curso2.model.clients.Client;
import com.cursos.curso2.model.clients.ports.ClientRepositoryPort;
import com.cursos.curso2.model.clients.ports.ClientServicePort;
import com.cursos.curso2.model.pets.ports.PetRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClientService implements ClientServicePort {

    private final ClientRepositoryPort clientRepositoryPort;

    private final PetRepositoryPort petRepository;


    @Override
    @Transactional
    public Client createClient(Client client) {
        return clientRepositoryPort.createClient(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepositoryPort.updateClient(client);
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
        return clientRepositoryPort.getClients();
    }
}
