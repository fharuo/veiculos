package com.tinnova.veiculos.model;

import com.tinnova.veiculos.dtos.VeiculoDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String veiculo;

    private Long marcaId;

    private Integer ano;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private Boolean vendido;

    private LocalDateTime created;
    private LocalDateTime updated;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "marcaId", insertable = false, updatable = false)
    private Marca marca;

    @PrePersist
    protected void onCreate() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now();
    }

    public Veiculo() {
    }

    public Veiculo(VeiculoDTO dto) {
        this.veiculo = dto.getVeiculo();
        this.marcaId = dto.getMarcaId();
        this.ano = dto.getAno();
        this.descricao = dto.getDescricao();
        this.vendido = dto.getVendido();
    }
}
