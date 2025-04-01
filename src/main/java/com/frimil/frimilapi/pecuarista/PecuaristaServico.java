package com.frimil.frimilapi.pecuarista;

import com.frimil.frimilapi.fazenda.Fazenda;
import com.frimil.frimilapi.fazenda.FazendaDTO;
import com.frimil.frimilapi.fazenda.FazendaServico;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;


@Service
@AllArgsConstructor
public class PecuaristaServico {

    private final PecuaristaRepositorio pecuaristaRepositorio;
    private final FazendaServico fazendaServico;

    public PecuaristaDTO cadastrar(PecuaristaDTO pecuaristaDTO) {

        validarEntrada(pecuaristaDTO);

        Pecuarista pecuarista = new Pecuarista();
        BeanUtils.copyProperties(pecuaristaDTO, pecuarista);

        pecuarista = pecuaristaRepositorio.save(pecuarista);

        if (!pecuaristaDTO.fazendas().isEmpty()) {
            Pecuarista finalPecuarista = pecuarista;
            List<Fazenda> fazendas = pecuaristaDTO.fazendas().stream()
                    .map(f -> {
                        Fazenda fazenda = new Fazenda(f);
                        fazenda.setPecuarista(finalPecuarista);
                        return fazendaServico.salvar(fazenda);
                    })
                    .toList();
            pecuarista.setFazendas(fazendas);
        }

        return new PecuaristaDTO(pecuarista);
    }

    public List<PecuaristaDTO> listar() {
        return pecuaristaRepositorio.findAll()
                .stream()
                .map(PecuaristaDTO::new)
                .collect(Collectors.toList());
    }

    public PecuaristaDTO buscar(Long id) {
        Pecuarista pecuarista = this.findOrThrow(id);

        return new PecuaristaDTO(pecuarista);
    }

    @Transactional
    public PecuaristaDTO atualizar(PecuaristaDTO pecuaristaDTO, Long id) {

        validarEntrada(pecuaristaDTO);

        Pecuarista pecuarista = findOrThrow(id);

        BeanUtils.copyProperties(pecuaristaDTO, pecuarista, "id", "fazendas");

        List<Fazenda> novasFazendas = new ArrayList<>();

        Pecuarista finalPecuarista = pecuarista;
        
        pecuaristaDTO.fazendas().forEach(fazenda -> {
            if (isNull(fazenda.getId())) {

               this.adicionarFazenda(fazenda, finalPecuarista, novasFazendas);

            } else {

                this.atualizarFazenda(fazenda);
            }
        });

        pecuarista.getFazendas().addAll(novasFazendas);

        pecuarista = pecuaristaRepositorio.save(pecuarista);
        return new PecuaristaDTO(pecuarista);
    }

    public void validarEntrada(PecuaristaDTO pecuaristaDTO) {
        if (pecuaristaDTO.fazendas().isEmpty()) {
            throw new RuntimeException("erro ao atualizar");
        }
    }

    public void adicionarFazenda(Fazenda fazenda, Pecuarista pecuarista, List<Fazenda> novasFazendas) {
        Fazenda novaFazenda = new Fazenda();
        novaFazenda.setNome(fazenda.getNome());
        novaFazenda.setMunicipio(fazenda.getMunicipio());
        novaFazenda.setPecuarista(pecuarista);
        novasFazendas.add(novaFazenda);
    }

    public void atualizarFazenda(Fazenda fazenda) {
        Fazenda fazendaExistente = fazendaServico.findOrThrow(fazenda.getId());

        fazendaExistente.setNome(fazenda.getNome());
        fazendaExistente.setMunicipio(fazenda.getMunicipio());

        fazendaServico.atualizar(new FazendaDTO(fazendaExistente), fazenda.getId());
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
