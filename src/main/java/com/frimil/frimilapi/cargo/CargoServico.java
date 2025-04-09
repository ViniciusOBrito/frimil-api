package com.frimil.frimilapi.cargo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class CargoServico {

    private final CargoRepositorio cargoRepositorio;

    public Cargo findOrCreate(String nome){

        Cargo cargo = cargoRepositorio.findByNome(nome).orElse(null);

        if (nonNull(cargo)){
            return cargo;
        }

        return cargoRepositorio.save(new Cargo(nome));
    }
}
