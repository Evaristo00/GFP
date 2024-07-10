package gestion.finanzas.personales.gfp.service;


import gestion.finanzas.personales.gfp.model.Presupuesto;

import java.util.List;

public interface PresupuestoService {

    List<Presupuesto> findByUsuarioId(Long usuarioId);
    Presupuesto save(Presupuesto presupuesto);
    void deleteById(Long id);
    Presupuesto findById(Long id);
}
