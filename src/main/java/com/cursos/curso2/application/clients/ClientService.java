package com.cursos.curso2.application.clients;

import com.cursos.curso2.model.clients.Client;
import com.cursos.curso2.model.clients.ports.ClientServicePort;

public class ClientService implements ClientServicePort {
    @Override
    public Client createClient(String name, String lastName, String email, String phone) {
        return null;
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
