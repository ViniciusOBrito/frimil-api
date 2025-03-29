package com.frimil.frimilapi.pesadorgado;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(name = "/pesador-gado")
public class PesadorGadoController {

    private final PesadorGadoServico pesadorGadoServico;

    @PostMapping
    public ResponseEntity<PesadorGadoDTO> cadastrar(@RequestBody PesadorGadoDTO pesadorGadoDTO) {
        return ResponseEntity.ok(this.pesadorGadoServico.cadastrar(pesadorGadoDTO));
    }

    @GetMapping
    public ResponseEntity<List<PesadorGadoDTO>> listar() {
        return ResponseEntity.ok(this.pesadorGadoServico.listar());
    }

    @GetMapping
    public ResponseEntity<PesadorGadoDTO> buscar(Long id) {
        return ResponseEntity.ok(this.pesadorGadoServico.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PesadorGadoDTO> atualizar(@RequestBody PesadorGadoDTO pesadorGadoDTO, Long id) {
        return ResponseEntity.ok(pesadorGadoServico.atualizar(pesadorGadoDTO, id));
    }

    @DeleteMapping
    public ResponseEntity<PesadorGadoDTO> excluir(Long id) {
        this.pesadorGadoServico.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
