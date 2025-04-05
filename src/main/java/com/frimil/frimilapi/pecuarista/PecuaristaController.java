package com.frimil.frimilapi.pecuarista;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pecuarista")
public class PecuaristaController {

    private final PecuaristaServico pecuaristaServico;

    @PostMapping()
    public ResponseEntity<PecuaristaDTO> cadastrar(@RequestBody PecuaristaDTO pecuaristaDTO) {
        return ResponseEntity.ok(pecuaristaServico.cadastrar(pecuaristaDTO));
    }

    @GetMapping()
    public ResponseEntity<List<PecuaristaDTO>> listar() {
        return ResponseEntity.ok(pecuaristaServico.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PecuaristaDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(pecuaristaServico.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PecuaristaDTO> atualizar(@RequestBody PecuaristaDTO pecuaristaDTO, @PathVariable Long id) {
        return ResponseEntity.ok(pecuaristaServico.atualizar(pecuaristaDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pecuaristaServico.excluir(id);
        return ResponseEntity.noContent().build();
    }


}
