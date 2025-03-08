package com.cursos.curso2.infraestructure.controllers;

import com.cursos.curso2.model.clients.Client;
import com.cursos.curso2.model.clients.ports.ClientServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientServicePort clientServicePort;

    @PutMapping("/create")
    public ResponseEntity<Client> createClient(@RequestParam("name") String name, @RequestParam("lastName") String lastName,
                                               @RequestParam("email") String email, @RequestParam("phone") String phone) {
        Client newClient = clientServicePort.createClient(name, lastName, email, phone);
        return ResponseEntity.ok().body(newClient);
    }

    @PostMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestParam("id") Long id, @RequestParam("name") String name,
                                               @RequestParam("lastName") String lastName, @RequestParam("email") String email,
                                               @RequestParam("phone") String phone) {
        Client clientUpdated = clientServicePort.updateClient(id, name, lastName, email, phone);
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

}
