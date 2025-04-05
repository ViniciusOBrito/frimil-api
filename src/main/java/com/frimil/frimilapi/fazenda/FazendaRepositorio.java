package com.frimil.frimilapi.fazenda;

import com.frimil.frimilapi.pecuarista.Pecuarista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FazendaRepositorio extends JpaRepository<Fazenda, Long> {

    List<Fazenda> findAllByPecuarista(Pecuarista pecuarista);
}
