package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.model.Gasto;
import gestion.finanzas.personales.gfp.model.Usuario;

import java.util.List;

public interface GastoService {
    List<Gasto> findByUsuarioId(Long usuarioId);
    List<Gasto> findByCategoriaId(Long categoriaId, Usuario usuario);
    Gasto save(Gasto gasto, Usuario usuario);
    void deleteById(Long id, Usuario usuario);
}
