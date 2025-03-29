package com.frimil.frimilapi.transportador;


import com.frimil.frimilapi.pesadorgado.PesadorGadoDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(name = "/transportador")
public class TransportadorController {

    private final TransportadorServico transportadorServico;

    @PostMapping
    public ResponseEntity<TransportadorDTO> cadastrar(@RequestBody TransportadorDTO transportadorDTO) {
        return ResponseEntity.ok(this.transportadorServico.cadastrar(transportadorDTO));
    }

    @GetMapping
    public ResponseEntity<List<TransportadorDTO>> listar() {
        return ResponseEntity.ok(this.transportadorServico.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransportadorDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(transportadorServico.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransportadorDTO> atualizar(@RequestBody TransportadorDTO transportadorDTO, @PathVariable Long id) {
        return ResponseEntity.ok(this.transportadorServico.atualizar(transportadorDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        transportadorServico.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
