package com.frimil.frimilapi.autenticacao;

import com.frimil.frimilapi.autenticacao.dto.LoginRequestDTO;
import com.frimil.frimilapi.autenticacao.dto.RegisterUserRequestDTO;
import com.frimil.frimilapi.autenticacao.dto.TokenResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Autenticacao Controller")
public interface AutenticacaoRecurso {

    @Operation(summary = "Login do usuário", description = "Realiza o login do usuário e retorna um token de autenticação.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Credenciais inválidas"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<TokenResponseDTO> loginUser(LoginRequestDTO dto);

    @Operation(summary = "Registro de usuário", description = "Realiza o registro de um novo usuário e retorna um token de autenticação.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<TokenResponseDTO> registerUser(RegisterUserRequestDTO dto);
}
