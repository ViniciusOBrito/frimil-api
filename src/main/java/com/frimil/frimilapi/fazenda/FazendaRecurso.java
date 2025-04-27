package com.frimil.frimilapi.fazenda;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Fazenda Controller")
public interface FazendaRecurso {

    @Operation(summary = "Atualizar fazenda", description = "Atualiza as informações de uma fazenda existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fazenda atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "404", description = "Fazenda não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<FazendaDTO> atualizar(FazendaDTO fazendaDTO, Long id);

    @Operation(summary = "Listar fazendas", description = "Recupera a lista de todas as fazendas cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de fazendas recuperada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<List<FazendaDTO>> listar();

    @Operation(summary = "Excluir fazenda", description = "Exclui uma fazenda do sistema pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Fazenda excluída com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido"),
            @ApiResponse(responseCode = "404", description = "Fazenda não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<Void> excluir(Long id);
}
