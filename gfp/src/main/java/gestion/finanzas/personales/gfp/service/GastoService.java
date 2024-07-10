package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.model.Gasto;

import java.util.List;

public interface GastoService {
    List<Gasto> findByUsuarioId(Long usuarioId);
    List<Gasto> findByCategoriaId(Long categoriaId);
    Gasto save(Gasto gasto);
    void deleteById(Long id);
    Gasto findById(Long id);
}
