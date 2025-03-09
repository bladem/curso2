package com.cursos.curso2.infraestructure.jdbc.pets;


import com.cursos.curso2.infraestructure.jdbc.clients.ClientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String breed;
    private String color;
    private String size;

    @ManyToOne
    private ClientEntity client;

}
