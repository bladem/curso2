package com.cursos.curso2.infraestructure.controllers;

import com.cursos.curso2.model.clients.Client;
import com.cursos.curso2.model.clients.ports.ClientServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientServicePort clientServicePort;

    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client newClient = clientServicePort.createClient(client);
        return ResponseEntity.ok().body(newClient);
    }

    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        Client clientUpdated = clientServicePort.updateClient(client);
        return ResponseEntity.ok().body(clientUpdated);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteClient(@RequestParam("id") Long id) {
        this.clientServicePort.deleteClient(id);
        return ResponseEntity.ok().body("Client deleted");
    }

    @GetMapping("/clientName")
    public Client getClient(@RequestParam("name") String name) {
        return this.clientServicePort.getClient(name);
    }

    @GetMapping("/clientId")
    public Client getClient(@RequestParam("id") Long id) {
        return this.clientServicePort.getClient(id);
    }

    @GetMapping("/clients")
    public List<Client> getClients() {
        return this.clientServicePort.getClients();
    }

}
