package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.dto.CategoriaRequestDto;
import gestion.finanzas.personales.gfp.dto.CategoriaResponseDto;
import gestion.finanzas.personales.gfp.repository.CategoriaRepository;
import gestion.finanzas.personales.gfp.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public CategoriaResponseDto save(CategoriaRequestDto categoriaRequestDto) {
        Categoria categoria = Categoria.builder()
                .nombre(categoriaRequestDto.nombre())
                .imagen(Base64.getDecoder().decode(categoriaRequestDto.imagen()))
                .build();
        categoria =  categoriaRepository.save(categoria);
        return CategoriaResponseDto.fromCategoria(categoria);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}