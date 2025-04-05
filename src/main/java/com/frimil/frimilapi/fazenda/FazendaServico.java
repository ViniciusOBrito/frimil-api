package com.frimil.frimilapi.fazenda;

import com.frimil.frimilapi.pecuarista.Pecuarista;
import com.frimil.frimilapi.pecuarista.PecuaristaServico;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FazendaServico {

    private final FazendaRepositorio fazendaRepositorio;

    public Fazenda salvar(Fazenda fazenda){
        return fazendaRepositorio.save(fazenda);
    }

    public List<FazendaDTO> listar() {
        return fazendaRepositorio.findAll()
                .stream()
                .map(FazendaDTO::new)
                .collect(Collectors.toList());
    }

    public FazendaDTO atualizar(FazendaDTO fazendaDTO, Long idFazenda) {
        Fazenda fazenda = findOrThrow(idFazenda);
        BeanUtils.copyProperties(fazendaDTO, fazenda);

        fazenda = fazendaRepositorio.save(fazenda);
        return new FazendaDTO(fazenda);
    }

    public void excluir(Long id) {
        Fazenda fazenda = findOrThrow(id);
        fazendaRepositorio.delete(fazenda);
    }


    public Fazenda findOrThrow(Long id) {
        return fazendaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro"));
    }
}
