package gestion.finanzas.personales.gfp.controller;

import gestion.finanzas.personales.gfp.dto.PresupuestoRequestDto;
import gestion.finanzas.personales.gfp.dto.PresupuestoResponseDto;
import gestion.finanzas.personales.gfp.model.Presupuesto;
import gestion.finanzas.personales.gfp.model.Usuario;
import gestion.finanzas.personales.gfp.service.PresupuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/presupuestos")
public class PresupuestoController {

    @Autowired
    private PresupuestoService presupuestoService;

    @GetMapping("/{id}")
    public ResponseEntity<Presupuesto> getPresupuestoById(@PathVariable Long id, @AuthenticationPrincipal Usuario usuario) {
        Presupuesto presupuesto = presupuestoService.findById(id,usuario);
        return ResponseEntity.ok(presupuesto);
    }

    @GetMapping("/usuario/{usuarioId}")
    @PreAuthorize("#usuarioId == authentication.principal.id")
    public ResponseEntity<List<Presupuesto>> getPresupuestosByUsuarioId(@PathVariable Long usuarioId) {
        List<Presupuesto> presupuestos = presupuestoService.findByUsuarioId(usuarioId);
        return ResponseEntity.ok(presupuestos);
    }

    @PostMapping
    public ResponseEntity<PresupuestoResponseDto> createPresupuesto(@RequestBody PresupuestoRequestDto presupuesto, @AuthenticationPrincipal Usuario usuario) {
        PresupuestoResponseDto newPresupuesto = presupuestoService.save(presupuesto,usuario);
        return ResponseEntity.ok(newPresupuesto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePresupuesto(@PathVariable Long id, @AuthenticationPrincipal Usuario usuario) {
        presupuestoService.deleteById(id,usuario);
        return ResponseEntity.noContent().build();
    }
}