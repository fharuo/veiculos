package com.tinnova.veiculos.controller;

import com.tinnova.veiculos.dtos.VeiculoDTO;
import com.tinnova.veiculos.dtos.VeiculosPorDecadaDAO;
import com.tinnova.veiculos.dtos.VeiculosPorFabricanteDAO;
import com.tinnova.veiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> listarVeiculos(@RequestParam(required = false) String marca,
                                                           @RequestParam(required = false) Integer ano) {
        List<VeiculoDTO> veiculos = veiculoService.buscarVeiculos(marca, ano);

        return ResponseEntity.ok(veiculos);
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> criarVeiculo(@RequestBody VeiculoDTO veiculoDTO) {
        VeiculoDTO novoVeiculo = veiculoService.inserirVeiculo(veiculoDTO);

        return ResponseEntity.ok(novoVeiculo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> veiculorPorId(@PathVariable Long id) {
        VeiculoDTO veiculoDTO = veiculoService.veiculorPorId(id);

        return ResponseEntity.ok(veiculoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDTO> atualizarVeiculo(@PathVariable Long id, @RequestBody VeiculoDTO veiculoDTO) {
        VeiculoDTO updatedVeiculo = veiculoService.atualizarVeiculo(id, veiculoDTO);

        return ResponseEntity.ok(updatedVeiculo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VeiculoDTO> patchVeiculo(@PathVariable Long id, @RequestBody VeiculoDTO veiculo) {
        return atualizarVeiculo(id, veiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        veiculoService.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nao-vendidos")
    public ResponseEntity<Long> contarVeiculosNaoVendidos() {
        long veiculosNaoVendidos = veiculoService.contarVeiculosNaoVendidos();

        return ResponseEntity.ok(veiculosNaoVendidos);
    }

    @GetMapping("/por-decada")
    public ResponseEntity<List<VeiculosPorDecadaDAO>> veiculosPorDecada() {
        List<VeiculosPorDecadaDAO> veiculos = veiculoService.listarVeiculosPorDecada();

        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/por-fabricante")
    public ResponseEntity<List<VeiculosPorFabricanteDAO>> veiculosPorFabricante() {
        List<VeiculosPorFabricanteDAO> veiculos = veiculoService.listarVeiculosPorFabricante();

        return ResponseEntity.ok(veiculos);

    }

    @GetMapping("/ultima-semana")
    public ResponseEntity<List<VeiculoDTO>> veiculosUltimaSemana() {
        List<VeiculoDTO> veiculos = veiculoService.listarVeiculosUltimaSemana();

        return ResponseEntity.ok(veiculos);
    }
}