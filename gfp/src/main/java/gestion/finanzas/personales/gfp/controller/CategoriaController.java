package gestion.finanzas.personales.gfp.controller;

import gestion.finanzas.personales.gfp.dto.CategoriaRequestDto;
import gestion.finanzas.personales.gfp.dto.CategoriaResponseDto;
import gestion.finanzas.personales.gfp.model.Categoria;
import gestion.finanzas.personales.gfp.model.Usuario;
import gestion.finanzas.personales.gfp.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.ok(categoria);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        List<Categoria> categorias = categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDto> createCategoria(@RequestBody CategoriaRequestDto categoria,@AuthenticationPrincipal Usuario usuario) {
        CategoriaResponseDto newCategoria = categoriaService.save(categoria);
        return ResponseEntity.ok(newCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}