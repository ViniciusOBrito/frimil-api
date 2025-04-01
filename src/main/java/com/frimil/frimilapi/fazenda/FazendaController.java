package com.frimil.frimilapi.fazenda;

import com.frimil.frimilapi.veiculo.VeiculoDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/fazenda")
public class FazendaController {

    private final FazendaServico fazendaServico;

    @PutMapping("/{id}")
    public ResponseEntity<FazendaDTO> atualizar(@RequestBody FazendaDTO fazendaDTO, @PathVariable Long id) {
        return ResponseEntity.ok(fazendaServico.atualizar(fazendaDTO, id));
    }

    @GetMapping
    public ResponseEntity<List<FazendaDTO>> listar() {
        return ResponseEntity.ok(fazendaServico.listar());
    }

    @DeleteMapping
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        fazendaServico.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
