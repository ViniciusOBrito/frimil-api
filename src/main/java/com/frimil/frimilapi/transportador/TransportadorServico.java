package com.frimil.frimilapi.transportador;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransportadorServico {

    private final TransportadorRepositorio transportadorRepositorio;

    public TransportadorDTO cadastrar(TransportadorDTO transportadorDTO) {
        Transportador transportador = new Transportador();
        BeanUtils.copyProperties(transportadorDTO, transportador);

        transportador = transportadorRepositorio.save(transportador);
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
        BeanUtils.copyProperties(transportadorDTO, transportador);

        transportador = transportadorRepositorio.save(transportador);
        return new TransportadorDTO(transportador);
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
