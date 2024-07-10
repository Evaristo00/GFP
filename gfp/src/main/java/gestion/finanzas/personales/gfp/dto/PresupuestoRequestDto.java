package gestion.finanzas.personales.gfp.dto;

import gestion.finanzas.personales.gfp.enums.Mes;

public record PresupuestoRequestDto(Float monto, Mes mes, Long idCategoria) {
}
