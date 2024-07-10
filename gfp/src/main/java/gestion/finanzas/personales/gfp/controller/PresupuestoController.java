package gestion.finanzas.personales.gfp.controller;

import gestion.finanzas.personales.gfp.model.Presupuesto;
import gestion.finanzas.personales.gfp.service.PresupuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/presupuestos")
public class PresupuestoController {

    @Autowired
    private PresupuestoService presupuestoService;

    @GetMapping("/{id}")
    public ResponseEntity<Presupuesto> getPresupuestoById(@PathVariable Long id) {
        Presupuesto presupuesto = presupuestoService.findById(id);
        return ResponseEntity.ok(presupuesto);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Presupuesto>> getPresupuestosByUsuarioId(@PathVariable Long usuarioId) {
        List<Presupuesto> presupuestos = presupuestoService.findByUsuarioId(usuarioId);
        return ResponseEntity.ok(presupuestos);
    }

    @PostMapping
    public ResponseEntity<Presupuesto> createPresupuesto(@RequestBody Presupuesto presupuesto) {
        Presupuesto newPresupuesto = presupuestoService.save(presupuesto);
        return ResponseEntity.ok(newPresupuesto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePresupuesto(@PathVariable Long id) {
        presupuestoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}