package com.frimil.frimilapi.pecuarista;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class PecuaristaServico {

    private final PecuaristaRepositorio pecuaristaRepositorio;

    public PecuaristaDTO cadastrar(PecuaristaDTO pecuaristaDTO) {
        Pecuarista pecuarista = new Pecuarista();
        BeanUtils.copyProperties(pecuaristaDTO, pecuarista);

        pecuarista = pecuaristaRepositorio.save(pecuarista);

        return new PecuaristaDTO(pecuarista);
    }

    public List<PecuaristaDTO> listar() {
        return pecuaristaRepositorio.findAll()
                .stream()
                .map(PecuaristaDTO::new)
                .collect(Collectors.toList());
    }

    public PecuaristaDTO buscarPecuarista(Long id) {
        Pecuarista pecuarista = this.findOrThrow(id);

        return new PecuaristaDTO(pecuarista);
    }

    public PecuaristaDTO editar(PecuaristaDTO pecuaristaDTO, Long id) {
        Pecuarista pecuarista = findOrThrow(id);

        BeanUtils.copyProperties(pecuaristaDTO, pecuarista);
        pecuarista = pecuaristaRepositorio.save(pecuarista);
        return new PecuaristaDTO(pecuarista);
    }

    public void excluir(Long id) {
        Pecuarista pecuarista = this.findOrThrow(id);
        pecuaristaRepositorio.delete(pecuarista);
    }

    public Pecuarista findOrThrow(Long id) {
        return pecuaristaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro"));
    }
}
