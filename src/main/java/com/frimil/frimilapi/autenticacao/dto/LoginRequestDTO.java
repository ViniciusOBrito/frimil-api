package com.frimil.frimilapi.autenticacao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "Login Request DTO", description = "DTO para requisição de login")
public record LoginRequestDTO(
        @Schema(description = "Email do usuário", example = "vinicius@example.com")
        @NotBlank(message = "Email é obrigatório")
        String email,
        @Schema(description = "Senha do usuário", example = "12345")
        @NotBlank(message = "Senha é obrigatório")
        String senha
) {
}
