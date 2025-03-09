package com.cursos.curso2.infraestructure.adapters.client;

import com.cursos.curso2.infraestructure.jdbc.clients.ClientEntity;
import com.cursos.curso2.infraestructure.jdbc.clients.ClientMapper;
import com.cursos.curso2.infraestructure.jdbc.clients.ClientRepository;
import com.cursos.curso2.model.clients.Client;
import com.cursos.curso2.model.clients.ports.ClientRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        ClientEntity clientEntity = clientRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Client not found"));
        clientEntity.setName(name);
        clientEntity.setLastName(lastName);
        clientEntity.setEmail(email);
        clientEntity.setPhone(phone);
        return clientMapper.toClient(clientRepository.save(clientEntity));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Client not found"));
        clientRepository.deleteById(id);
    }

    @Override
    public Client getClient(String name) {
        return Optional.ofNullable(clientRepository.findByName(name)).map(clientMapper::toClient).orElse(null);
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).map(clientMapper::toClient).orElse(null);
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll().stream().map(clientMapper::toClient).toList();
    }
}
