package com.frimil.frimilapi.veiculo;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/veiculo")
public class VeiculoController {

    private final VeiculoServico veiculoServico;

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDTO> atualizar(@RequestBody VeiculoDTO veiculoDTO, @PathVariable Long id) {
        return ResponseEntity.ok(veiculoServico.atualizar(veiculoDTO, id));
    }

    @GetMapping("/{idTransportador}")
    public ResponseEntity<List<VeiculoDTO>> listarPorTransportador(@PathVariable Long idTransportador) {
        return ResponseEntity.ok(veiculoServico.listarPorTransportador(idTransportador));
    }

    @GetMapping()
    public ResponseEntity<List<VeiculoDTO>> listar() {
        return ResponseEntity.ok(this.veiculoServico.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        veiculoServico.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
