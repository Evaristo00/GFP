package gestion.finanzas.personales.gfp.dto;

import gestion.finanzas.personales.gfp.model.Gasto;
import lombok.Builder;

@Builder
public record GastosResponseDto(Long id, Float monto, UsuarioResponse usuario, CategoriaResponseDto categoria) {

    public GastosResponseDto fromGasto(Gasto gasto) {
        return GastosResponseDto.builder()
                .id(gasto.getId())
                .monto(gasto.getMonto())
                .usuario(UsuarioResponse.fromUsuario(gasto.getUsuario()))
                .categoria(this.categoria)
                .build();
    }
}
