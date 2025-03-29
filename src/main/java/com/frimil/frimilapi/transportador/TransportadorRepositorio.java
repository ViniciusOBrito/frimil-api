package com.frimil.frimilapi.transportador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransportadorRepositorio extends JpaRepository<Transportador, Long> {
}
