package com.frimil.frimilapi.transportador;

import com.frimil.frimilapi.veiculo.Veiculo;

import java.util.List;

public record TransportadorDTO(
        Long id,
        Long tipoDocumento,
        String documento,
        String nome,
        String nomeFantasia,
        String endereco,
        String telefone,
        List<Veiculo> veiculos
) {

    public TransportadorDTO(Transportador transportador) {
        this(
                transportador.getId(),
                transportador.getTipoDocumento(),
                transportador.getDocumento(),
                transportador.getNome(),
                transportador.getNomeFantasia(),
                transportador.getEndereco(),
                transportador.getTelefone(),
                transportador.getVeiculos()
        );
    }
}
