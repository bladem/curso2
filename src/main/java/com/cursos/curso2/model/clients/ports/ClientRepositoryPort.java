package com.cursos.curso2.model.clients.ports;

import com.cursos.curso2.model.clients.Client;

import java.util.List;

public interface ClientRepositoryPort {
    Client createClient(Client client);
    Client updateClient(Client client);
    void deleteClient(Long id);
    Client getClient(String name);
    Client getClient(Long id);
    List<Client> getClients();
}
