package com.tinnova.veiculos.controller;

import com.tinnova.veiculos.model.Marca;
import com.tinnova.veiculos.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping
    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }
}
