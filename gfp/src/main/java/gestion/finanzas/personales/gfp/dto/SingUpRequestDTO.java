package gestion.finanzas.personales.gfp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SingUpRequestDTO(

        @Schema(description = "Email de usuario", example = "UsuarioDePrueba@example.com")
        @NotBlank
        @Email
        String email,
        @Schema(description = "Contraseña del usuario", example = "123")
        @NotBlank
        String password) {
}

