package com.frimil.frimilapi.pesadorgado;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PesadorGadoServico {

    private final PesadorGadoRepositorio pesadorGadoRepositorio;

    public PesadorGadoDTO cadastrar(PesadorGadoDTO pesadorGadoDTO) {
        PesadorGado pesadorGado = new PesadorGado();
        BeanUtils.copyProperties(pesadorGadoDTO, pesadorGado);

        pesadorGado = pesadorGadoRepositorio.save(pesadorGado);
        return new PesadorGadoDTO(pesadorGado);
    }

    public List<PesadorGadoDTO> listar() {
        return pesadorGadoRepositorio.findAll()
                .stream()
                .map(PesadorGadoDTO::new)
                .collect(Collectors.toList());
    }

    public PesadorGadoDTO buscar(Long id) {
        PesadorGado pesadorGado = this.findOrThrow(id);

        return new PesadorGadoDTO(pesadorGado);
    }

    public PesadorGadoDTO atualizar(PesadorGadoDTO pesadorGadoDTO, Long id) {
        PesadorGado pesadorGado = this.findOrThrow(id);
        BeanUtils.copyProperties(pesadorGadoDTO, pesadorGado);

        pesadorGado = pesadorGadoRepositorio.save(pesadorGado);
        return new PesadorGadoDTO(pesadorGado);
    }

    public void excluir(Long id) {
        PesadorGado pesadorGado = this.findOrThrow(id);
        pesadorGadoRepositorio.delete(pesadorGado);
    }

    public PesadorGado findOrThrow(Long id) {
        return pesadorGadoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro"));
    }
}
