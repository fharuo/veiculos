package com.tinnova.veiculos.repository;

import com.tinnova.veiculos.dtos.VeiculosPorDecadaDAO;
import com.tinnova.veiculos.dtos.VeiculosPorFabricanteDAO;
import com.tinnova.veiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    long countByVendidoFalse();

    @Query("SELECT v FROM Veiculo v WHERE "
            + "(:marca IS NULL OR v.marca.descricao = :marca) AND "
            + "(:ano IS NULL OR v.ano = :ano)")
    List<Veiculo> findByMarcaAnoCor(@Param("marca") String marca, @Param("ano") Integer ano);

    @Query("SELECT v FROM Veiculo v WHERE v.created >= :oneWeekAgo")
    List<Veiculo> findVeiculosRegistradosUltimaSemana(LocalDateTime oneWeekAgo);

    @Query("SELECT v.ano / 10 * 10 as decada, COUNT(v) as total FROM Veiculo v GROUP BY decada")
    List<VeiculosPorDecadaDAO> findVeiculosPorDecada();

    @Query("SELECT v.marca.descricao as fabricante, COUNT(v) as total FROM Veiculo v GROUP BY v.marca.descricao")
    List<VeiculosPorFabricanteDAO> findVeiculosPorFabricante();
}
