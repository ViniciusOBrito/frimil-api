package com.frimil.frimilapi.pesadorgado;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Pesador Gado Controller")
public interface PesadorGadoRecurso {

    @Operation(summary = "Cadastrar novo pesador de gado", description = "Registra um novo pesador de gado no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pesador de gado cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<PesadorGadoDTO> cadastrar(PesadorGadoDTO pesadorGadoDTO);

    @Operation(summary = "Listar pesadores de gado", description = "Recupera a lista de todos os pesadores de gado cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pesadores de gado recuperada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<List<PesadorGadoDTO>> listar();

    @Operation(summary = "Buscar pesador de gado por ID", description = "Recupera um pesador de gado específico através do seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pesador de gado recuperado com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido"),
            @ApiResponse(responseCode = "404", description = "Pesador de gado não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<PesadorGadoDTO> buscar(Long id);

    @Operation(summary = "Atualizar dados do pesador de gado", description = "Atualiza as informações de um pesador de gado existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pesador de gado atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "404", description = "Pesador de gado não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<PesadorGadoDTO> atualizar(PesadorGadoDTO pesadorGadoDTO, Long id);

    @Operation(summary = "Excluir pesador de gado", description = "Exclui um pesador de gado do sistema pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pesador de gado excluído com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido"),
            @ApiResponse(responseCode = "404", description = "Pesador de gado não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<Void> excluir(Long id);
}
