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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @GetMapping()
    public ResponseEntity<List<GastosResponseDto>> getGastosByUsuarioId(@AuthenticationPrincipal Usuario usuario) {
        List<Gasto> gastos = gastoService.findByUsuarioId(usuario.getId());
        GastosResponseDto response = GastosResponseDto.builder().build();
        return ResponseEntity.ok(gastos.stream().map(response::fromGasto).collect(Collectors.toList()));
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<GastosResponseDto>> getGastosByCategoriaId(@PathVariable Long categoriaId,@AuthenticationPrincipal Usuario usuario) {
        List<Gasto> gastos = gastoService.findByCategoriaId(categoriaId, usuario);
        GastosResponseDto response = GastosResponseDto.builder().build();
        return  ResponseEntity.ok(gastos.stream().map(response::fromGasto).collect(Collectors.toList()));
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