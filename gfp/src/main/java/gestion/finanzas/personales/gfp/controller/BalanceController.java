package gestion.finanzas.personales.gfp.controller;

import gestion.finanzas.personales.gfp.dto.BalanceDto;
import gestion.finanzas.personales.gfp.model.Usuario;
import gestion.finanzas.personales.gfp.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/balances")
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping
    public ResponseEntity<List<BalanceDto>> getBalances(@AuthenticationPrincipal Usuario usuario) {
        return ResponseEntity.ok(balanceService.listBalances(usuario));
    }
}
