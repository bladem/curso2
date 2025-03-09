package com.cursos.curso2.model.pets;

import com.cursos.curso2.model.clients.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pet {
    private Long idPet;
    private String name;
    private String type;
    private String breed;
    private String color;
    private String size;
    private Client client;
}
