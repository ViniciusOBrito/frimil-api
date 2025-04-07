package com.frimil.frimilapi.veiculo;

import com.frimil.frimilapi.fazenda.Fazenda;
import com.frimil.frimilapi.transportador.Transportador;
import com.frimil.frimilapi.transportador.TransportadorServico;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VeiculoServico {

    private final VeiculoRepositorio veiculoRepositorio;

    public Veiculo salvar(Veiculo veiculo){
        return veiculoRepositorio.save(veiculo);
    }

    public List<VeiculoDTO> listar() {
        return veiculoRepositorio.findAll()
                .stream()
                .map(VeiculoDTO::new)
                .collect(Collectors.toList());
    }


    public VeiculoDTO atualizar(VeiculoDTO veiculoDTO, Long id) {
        Veiculo veiculo = findOrThrow(id);
        BeanUtils.copyProperties(veiculoDTO, veiculo);

        veiculo = veiculoRepositorio.save(veiculo);

        return new VeiculoDTO(veiculo);
    }

    public void excluir(Long id) {
        Veiculo veiculo = findOrThrow(id);
        veiculoRepositorio.delete(veiculo);
    }

    public Veiculo findOrThrow(Long id) {
        return veiculoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro"));
    }
}
