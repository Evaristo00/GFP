package gestion.finanzas.personales.gfp.dto;

import gestion.finanzas.personales.gfp.enums.Mes;
import gestion.finanzas.personales.gfp.model.Categoria;
import gestion.finanzas.personales.gfp.model.Presupuesto;
import lombok.Builder;

@Builder
public record PresupuestoResponseDto(Long id, Float monto, Mes mes, UsuarioResponse usuario, CategoriaResponseDto categoria) {
    public static PresupuestoResponseDto fromPresupuesto(Presupuesto presupuesto) {
        return PresupuestoResponseDto.builder()
                .id(presupuesto.getId())
                .monto(presupuesto.getMonto())
                .mes(presupuesto.getMes())
                .usuario(UsuarioResponse.fromUsuario(presupuesto.getUsuario()))
                .categoria(CategoriaResponseDto.fromCategoria(presupuesto.getCategoria()))
                .build();
    }
}
