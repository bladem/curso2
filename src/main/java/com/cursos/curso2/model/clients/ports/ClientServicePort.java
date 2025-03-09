package com.cursos.curso2.model.clients.ports;

import com.cursos.curso2.model.clients.Client;

import java.util.List;

public interface ClientServicePort {
    Client createClient(String name, String lastName, String email, String phone);
    Client updateClient(Long id, String name, String lastName, String email, String phone);
    void deleteClient(Long id);
    Client getClient(String name);
    Client getClient(Long id);
    List<Client> getClients();
}
