package com.tinnova.veiculos.service;

import com.tinnova.veiculos.dtos.VeiculoDTO;
import com.tinnova.veiculos.dtos.VeiculosPorDecadaDAO;
import com.tinnova.veiculos.dtos.VeiculosPorFabricanteDAO;
import com.tinnova.veiculos.exceptions.NotFoundException;
import com.tinnova.veiculos.model.Veiculo;
import com.tinnova.veiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional(readOnly = true)
    public List<VeiculoDTO> buscarVeiculos(String marca, Integer ano) {
        List<Veiculo> veiculos = veiculoRepository.findByMarcaAnoCor(marca, ano);

        return veiculos.stream().map(VeiculoDTO::new).toList();
    }

    @Transactional
    public VeiculoDTO inserirVeiculo(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = new Veiculo(veiculoDTO);
        Veiculo saved = veiculoRepository.save(veiculo);

        return new VeiculoDTO(saved);
    }

    @Transactional
    public VeiculoDTO atualizarVeiculo(Long id, VeiculoDTO dto) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o veiculo"));

        veiculo.setVeiculo(dto.getVeiculo());
        veiculo.setMarcaId(dto.getMarcaId());
        veiculo.setAno(dto.getAno());
        veiculo.setDescricao(dto.getDescricao());
        veiculo.setVendido(dto.getVendido());
        Veiculo updated = veiculoRepository.save(veiculo);

        return new VeiculoDTO(updated);
    }

    @Transactional
    public void deletarVeiculo(Long veiculoId) {
        veiculoRepository.findById(veiculoId)
                .ifPresent(veiculo -> veiculoRepository.deleteById(veiculoId));
    }

    @Transactional(readOnly = true)
    public List<VeiculoDTO> listarVeiculosUltimaSemana() {
        List<Veiculo> veiculos = veiculoRepository.findVeiculosRegistradosUltimaSemana(LocalDateTime.now().minusWeeks(1));

        return veiculos.stream().map(VeiculoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<VeiculosPorFabricanteDAO> listarVeiculosPorFabricante() {
        return veiculoRepository.findVeiculosPorFabricante();
    }

    @Transactional(readOnly = true)
    public List<VeiculosPorDecadaDAO> listarVeiculosPorDecada() {
        return veiculoRepository.findVeiculosPorDecada();
    }

    @Transactional(readOnly = true)
    public long contarVeiculosNaoVendidos() {
        return veiculoRepository.countByVendidoFalse();
    }

    public VeiculoDTO veiculorPorId(Long id) {
        return veiculoRepository.findById(id)
                .map(VeiculoDTO::new)
                .orElseThrow(() -> new NotFoundException("Veiculo nao encontrado"));
    }
}


