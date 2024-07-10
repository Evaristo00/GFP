package gestion.finanzas.personales.gfp.dto;

import gestion.finanzas.personales.gfp.model.Usuario;
import lombok.Builder;
@Builder
public record UsuarioResponse(Long id,String mail) {

    public static UsuarioResponse fromUsuario(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .mail(usuario.getMail())
                .build();
    }
}

