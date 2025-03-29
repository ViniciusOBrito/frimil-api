package com.frimil.frimilapi.pesadorgado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesadorGadoRepositorio extends JpaRepository<PesadorGado, Long> {
}
