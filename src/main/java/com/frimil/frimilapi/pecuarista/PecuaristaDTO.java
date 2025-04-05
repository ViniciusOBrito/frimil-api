package com.frimil.frimilapi.pecuarista;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.frimil.frimilapi.fazenda.Fazenda;
import com.frimil.frimilapi.fazenda.FazendaDTO;

import java.util.List;

public record PecuaristaDTO(
        Long id,
        Long sequencial,
        Long tipoDocumento,
        String documento,
        String nome,
        String nomeFantasia,
        String inscricaoEstadual,
        String endereco,
        String telefone,
        String rg,
        List<Fazenda> fazendas
) {

    public PecuaristaDTO(Pecuarista pecuarista) {
        this(
                pecuarista.getId(),
                pecuarista.getSequencial(),
                pecuarista.getTipoDocumento(),
                pecuarista.getDocumento(),
                pecuarista.getNome(),
                pecuarista.getNomeFantasia(),
                pecuarista.getInscricaoEstadual(),
                pecuarista.getEndereco(),
                pecuarista.getTelefone(),
                pecuarista.getRg(),
                pecuarista.getFazendas()
        );
    }
}
