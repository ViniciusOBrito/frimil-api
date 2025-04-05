package com.frimil.frimilapi.pesadorgado;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pesador-gado")
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

    @GetMapping("/{id}")
    public ResponseEntity<PesadorGadoDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(this.pesadorGadoServico.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PesadorGadoDTO> atualizar(@RequestBody PesadorGadoDTO pesadorGadoDTO,@PathVariable Long id) {
        return ResponseEntity.ok(pesadorGadoServico.atualizar(pesadorGadoDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PesadorGadoDTO> excluir(@PathVariable Long id) {
        this.pesadorGadoServico.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
