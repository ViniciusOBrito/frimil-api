package com.frimil.frimilapi.transportador;

import com.frimil.frimilapi.fazenda.Fazenda;
import com.frimil.frimilapi.fazenda.FazendaDTO;
import com.frimil.frimilapi.pecuarista.Pecuarista;
import com.frimil.frimilapi.veiculo.Veiculo;
import com.frimil.frimilapi.veiculo.VeiculoDTO;
import com.frimil.frimilapi.veiculo.VeiculoServico;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class TransportadorServico {

    private final TransportadorRepositorio transportadorRepositorio;
    private final VeiculoServico veiculoServico;

    public TransportadorDTO cadastrar(TransportadorDTO transportadorDTO) {
        Transportador transportador = new Transportador();
        BeanUtils.copyProperties(transportadorDTO, transportador);

        transportador = transportadorRepositorio.save(transportador);

        if (!transportadorDTO.veiculos().isEmpty()) {
            Transportador finalTransportador = transportador;
            List<Veiculo> veiculos = transportadorDTO.veiculos().stream()
                    .map(v -> {
                        Veiculo veiculo = new Veiculo(v);
                        veiculo.setTransportador(finalTransportador);
                        return veiculoServico.salvar(veiculo);
                    })
                    .toList();
            transportador.setVeiculos(veiculos);
        }

        return new TransportadorDTO(transportador);
    }

    public List<TransportadorDTO> listar() {
        return transportadorRepositorio.findAll()
                .stream()
                .map(TransportadorDTO::new)
                .collect(Collectors.toList());
    }

    public TransportadorDTO buscar(Long id) {
        Transportador transportador = this.findOrThrow(id);
        return new TransportadorDTO(transportador);
    }

    public TransportadorDTO atualizar(TransportadorDTO transportadorDTO, Long id) {
        Transportador transportador = this.findOrThrow(id);

        BeanUtils.copyProperties(transportadorDTO, transportador, "id", "veiculos");

        List<Veiculo> novosVeiculos = new ArrayList<>();

        Transportador finalTransportador = transportador;

        transportadorDTO.veiculos().forEach(veiculo -> {
            if (isNull(veiculo.getId())) {

                this.adicionarVeiculo(veiculo, finalTransportador, novosVeiculos);

            } else {

                this.atualizarVeiculo(veiculo);
            }
        });

        transportador.getVeiculos().addAll(novosVeiculos);

        transportador = transportadorRepositorio.save(transportador);

        return new TransportadorDTO(transportador);
    }

    public void adicionarVeiculo(Veiculo veiculo, Transportador transportador, List<Veiculo> novosVeiculos) {
        Veiculo novoVeiculo = new Veiculo();
        novoVeiculo.setVeiculo(veiculo.getVeiculo());
        novoVeiculo.setPlaca(veiculo.getPlaca());
        novoVeiculo.setCapacidade(veiculo.getCapacidade());
        novoVeiculo.setTransportador(transportador);
        novosVeiculos.add(novoVeiculo);
    }

    public void atualizarVeiculo(Veiculo veiculo) {
        Veiculo veiculoExistente = veiculoServico.findOrThrow(veiculo.getId());

        veiculoExistente.setVeiculo(veiculo.getVeiculo());
        veiculoExistente.setCapacidade(veiculo.getCapacidade());

        veiculoServico.atualizar(new VeiculoDTO(veiculoExistente), veiculo.getId());
    }

    public void excluir(Long id) {
        Transportador transportador = this.findOrThrow(id);
        transportadorRepositorio.delete(transportador);
    }

    public Transportador findOrThrow(Long id) {
        return transportadorRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro"));
    }
}
