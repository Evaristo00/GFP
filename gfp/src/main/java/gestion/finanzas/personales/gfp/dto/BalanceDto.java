package gestion.finanzas.personales.gfp.dto;

import gestion.finanzas.personales.gfp.model.Categoria;
import lombok.Builder;

@Builder
public record BalanceDto(CategoriaResponseDto categoria, Double montoGastado, Double montoParaGastar) {
}
