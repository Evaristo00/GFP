package gestion.finanzas.personales.gfp.service;


import gestion.finanzas.personales.gfp.dto.PresupuestoRequestDto;
import gestion.finanzas.personales.gfp.dto.PresupuestoResponseDto;
import gestion.finanzas.personales.gfp.model.Presupuesto;
import gestion.finanzas.personales.gfp.model.Usuario;

import java.util.List;

public interface PresupuestoService {

    List<Presupuesto> findByUsuarioId(Long usuarioId);
    PresupuestoResponseDto save(PresupuestoRequestDto presupuesto, Usuario usuario);
    void deleteById(Long id);
    Presupuesto findById(Long id, Usuario usuario);
}
