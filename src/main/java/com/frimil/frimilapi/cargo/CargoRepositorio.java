package com.frimil.frimilapi.cargo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CargoRepositorio extends CrudRepository<Cargo, UUID> {

    Optional<Cargo> findByNome(String nome);
}
