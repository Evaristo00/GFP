package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.model.Categoria;

import java.util.List;

public interface CategoriaService {
    Categoria save(Categoria categoria);
    void deleteById(Long id);
    Categoria findById(Long id);
    List<Categoria> findAll();
}
