package gestion.finanzas.personales.gfp.dto;

import gestion.finanzas.personales.gfp.model.Usuario;
import lombok.Builder;

@Builder
public record JwtAuthenticationResponse (String token, UsuarioResponse user) {
}
