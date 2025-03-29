package com.frimil.frimilapi.fazenda;

import com.frimil.frimilapi.pecuarista.Pecuarista;

public record FazendaDTO(
        Long id,
        String nome,
        String municipio,
        Pecuarista pecuarista
) {

    public FazendaDTO(Fazenda fazenda){
        this(
                fazenda.getId(),
                fazenda.getNome(),
                fazenda.getMunicipio(),
                fazenda.getPecuarista()
        );
    }
}
