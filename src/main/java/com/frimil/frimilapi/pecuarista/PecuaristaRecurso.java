package com.frimil.frimilapi.pecuarista;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Pecurista Controller")
public interface PecuaristaRecurso {

    @Operation(summary = "Cadastrar novo pecuarista", description = "Registra um novo pecuarista no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pecuarista cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<PecuaristaDTO> cadastrar(PecuaristaDTO pecuaristaDTO);

    @Operation(summary = "Listar pecuaristas", description = "Recupera a lista de todos os pecuaristas cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pecuaristas recuperada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<List<PecuaristaDTO>> listar();

    @Operation(summary = "Buscar pecuarista por ID", description = "Recupera um pecuarista específico através do seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pecuarista recuperado com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido"),
            @ApiResponse(responseCode = "404", description = "Pecuarista não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<PecuaristaDTO> buscar(Long id);

    @Operation(summary = "Atualizar dados do pecuarista", description = "Atualiza as informações de um pecuarista existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pecuarista atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "404", description = "Pecuarista não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<PecuaristaDTO> atualizar(PecuaristaDTO pecuaristaDTO, Long id);

    @Operation(summary = "Excluir pecuarista", description = "Exclui um pecuarista do sistema pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pecuarista excluído com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido"),
            @ApiResponse(responseCode = "404", description = "Pecuarista não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<Void> deletar(Long id);
}
