package com.cursos.curso2.infraestructure.adapters.client;

import com.cursos.curso2.infraestructure.jdbc.clients.ClientMapper;
import com.cursos.curso2.infraestructure.jdbc.clients.ClientRepository;
import com.cursos.curso2.model.clients.Client;
import com.cursos.curso2.model.clients.ports.ClientRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientRepositoryAdapter implements ClientRepositoryPort {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;


    @Override
    public Client createClient(String name, String lastName, String email, String phone) {
        Client client = Client.builder()
                .name(name)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .build();

        return clientMapper.toClient(clientRepository.save(clientMapper.toClientEntity(client)));
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
