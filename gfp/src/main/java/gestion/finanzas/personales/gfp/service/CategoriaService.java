package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.dto.CategoriaRequestDto;
import gestion.finanzas.personales.gfp.dto.CategoriaResponseDto;
import gestion.finanzas.personales.gfp.model.Categoria;

import java.util.List;

public interface CategoriaService {
    CategoriaResponseDto save(CategoriaRequestDto categoria);
    void deleteById(Long id);
    Categoria findById(Long id);
    List<Categoria> findAll();
}
