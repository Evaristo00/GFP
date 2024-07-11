package gestion.finanzas.personales.gfp.controller;

import gestion.finanzas.personales.gfp.dto.GastosRequestDto;
import gestion.finanzas.personales.gfp.dto.GastosResponseDto;
import gestion.finanzas.personales.gfp.model.Gasto;
import gestion.finanzas.personales.gfp.model.Usuario;
import gestion.finanzas.personales.gfp.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @GetMapping()
    public ResponseEntity<List<Gasto>> getGastosByUsuarioId(@AuthenticationPrincipal Usuario usuario) {
        List<Gasto> gastos = gastoService.findByUsuarioId(usuario.getId());
        return ResponseEntity.ok(gastos);
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Gasto>> getGastosByCategoriaId(@PathVariable Long categoriaId,@AuthenticationPrincipal Usuario usuario) {
        List<Gasto> gastos = gastoService.findByCategoriaId(categoriaId, usuario);
        return ResponseEntity.ok(gastos);
    }

    @PostMapping
    public ResponseEntity<GastosResponseDto> createGasto(@RequestBody GastosRequestDto gasto, @AuthenticationPrincipal Usuario usuario) {
        GastosResponseDto newGasto = gastoService.save(gasto,usuario);
        return ResponseEntity.ok(newGasto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGasto(@PathVariable Long id, @AuthenticationPrincipal Usuario usuario) {
        gastoService.deleteById(id,usuario);
        return ResponseEntity.noContent().build();
    }
}