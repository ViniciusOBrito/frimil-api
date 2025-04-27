package com.frimil.frimilapi.transportador;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Transportador Controller")
public interface TransportadorResource {

    @Operation(summary = "Cadastrar novo transportador", description = "Registra um novo transportador no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transportador cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<TransportadorDTO> cadastrar(TransportadorDTO transportadorDTO);

    @Operation(summary = "Listar transportadores", description = "Recupera a lista de todos os transportadores cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de transportadores recuperada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<List<TransportadorDTO>> listar();

    @Operation(summary = "Buscar transportador por ID", description = "Recupera um transportador específico através do seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transportador recuperado com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido"),
            @ApiResponse(responseCode = "404", description = "Transportador não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<TransportadorDTO> buscar(Long id);

    @Operation(summary = "Atualizar dados do transportador", description = "Atualiza as informações de um transportador existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transportador atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "404", description = "Transportador não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<TransportadorDTO> atualizar(TransportadorDTO transportadorDTO, Long id);

    @Operation(summary = "Excluir transportador", description = "Exclui um transportador do sistema pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Transportador excluído com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido"),
            @ApiResponse(responseCode = "404", description = "Transportador não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<Void> remover(Long id);
}
