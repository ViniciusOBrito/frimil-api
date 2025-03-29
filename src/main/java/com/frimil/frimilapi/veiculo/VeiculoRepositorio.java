package com.frimil.frimilapi.veiculo;

import com.frimil.frimilapi.transportador.Transportador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findAllByTransportador(Transportador transportador);
}
