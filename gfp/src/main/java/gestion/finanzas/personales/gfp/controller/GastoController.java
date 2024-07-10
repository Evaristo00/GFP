package gestion.finanzas.personales.gfp.controller;

import gestion.finanzas.personales.gfp.model.Gasto;
import gestion.finanzas.personales.gfp.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @GetMapping("/{id}")
    public ResponseEntity<Gasto> getGastoById(@PathVariable Long id) {
        Gasto gasto = gastoService.findById(id);
        return ResponseEntity.ok(gasto);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Gasto>> getGastosByUsuarioId(@PathVariable Long usuarioId) {
        List<Gasto> gastos = gastoService.findByUsuarioId(usuarioId);
        return ResponseEntity.ok(gastos);
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Gasto>> getGastosByCategoriaId(@PathVariable Long categoriaId) {
        List<Gasto> gastos = gastoService.findByCategoriaId(categoriaId);
        return ResponseEntity.ok(gastos);
    }

    @PostMapping
    public ResponseEntity<Gasto> createGasto(@RequestBody Gasto gasto) {
        Gasto newGasto = gastoService.save(gasto);
        return ResponseEntity.ok(newGasto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGasto(@PathVariable Long id) {
        gastoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}