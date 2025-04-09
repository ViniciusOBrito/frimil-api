package com.frimil.frimilapi.autenticacao.dto;

import com.frimil.frimilapi.cargo.Cargo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Schema(name = "Register User Request DTO", description = "DTO para registrar novo usuário")

public record RegisterUserRequestDTO(
        @Schema(description = "Nome do novo usuário", example = "vinicius brito")
        @NotBlank(message = "Name é obrigatório")
        String name,
        @Schema(description = "Email do novo usuário", example = "vinicius.admin@example.com")
        @NotBlank(message = "Email é obrigatório")
        String email,
        @Schema(description = "Senha do novo usuário", example = "12345")
        @NotBlank(message = "Senha é obrigatório")
        String senha,
        @Schema(description = "Telefone do novo usuário", example = "98080-8080")
        @NotBlank(message = "Telefone é obrigatório")
        String telefone,
        @Schema(description = "Cargo do novo usuário", example = "ADMIN")
        @NotNull(message = "Cargo é obrigatório")
        Cargo cargo
) {
}
