package com.tinnova.veiculos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String descricao;

    public Marca() {}
}
