package com.tinnova.veiculos.dtos;

import com.tinnova.veiculos.model.Veiculo;
import lombok.Data;

@Data
public class VeiculoDTO {

    private Long id;

    private String veiculo;

    private Long marcaId;

    private Integer ano;

    private String descricao;

    private Boolean vendido;

    public VeiculoDTO() {}

    public VeiculoDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.veiculo = veiculo.getVeiculo();
        this.marcaId = veiculo.getMarcaId();
        this.ano = veiculo.getAno();
        this.descricao = veiculo.getDescricao();
        this.vendido = veiculo.getVendido();
    }
}
