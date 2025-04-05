package com.frimil.frimilapi.veiculo;

import com.frimil.frimilapi.transportador.Transportador;

public record VeiculoDTO(
        Long id,
        String veiculo,
        String placa,
        Long capacidade,
        Transportador transportador
) {

    public VeiculoDTO (Veiculo veiculo){
        this(
                veiculo.getId(),
                veiculo.getVeiculo(),
                veiculo.getPlaca(),
                veiculo.getCapacidade(),
                veiculo.getTransportador()
        );
    }
}
