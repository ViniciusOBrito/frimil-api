package com.frimil.frimilapi.autenticacao.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Token Responde DTO", description = "DTO para retornar informações sobre o usuário que solicitou o token.")
public record TokenResponseDTO(
        @Schema(description = "Token provido no login/registro", example = "eyJhbGciOiJIUzI1NiIsInR....")
        String token,
        @Schema(description = "Tempo de expiração do token", example = "2024-09-25T23:51:46.774942800Z")
        String expiraEm,
        @Schema(description = "Nome do usuário que gerou o token", example = "vinicius")
        String nome
) {
}
