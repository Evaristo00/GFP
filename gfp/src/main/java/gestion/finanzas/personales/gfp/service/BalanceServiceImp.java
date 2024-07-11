package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.dto.BalanceDto;
import gestion.finanzas.personales.gfp.dto.CategoriaResponseDto;
import gestion.finanzas.personales.gfp.model.Categoria;
import gestion.finanzas.personales.gfp.model.Gasto;
import gestion.finanzas.personales.gfp.model.Presupuesto;
import gestion.finanzas.personales.gfp.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BalanceServiceImp implements BalanceService{

    @Autowired
    private PresupuestoService presupuestoService;

    @Autowired
    private GastoService gastoService;

    @Override
    public List<BalanceDto> listBalances(Usuario usuario) {
        List<Presupuesto> presupuestos = presupuestoService.findByUsuarioId(usuario.getId());
        List<Gasto> gastos = gastoService.findByUsuarioId(usuario.getId());
        // Agrupa los presupuestos por categoría y suma los montos
        Map<Categoria, Double> totalPresupuestadoPorCategoria = presupuestos.stream()
                .collect(Collectors.groupingBy(Presupuesto::getCategoria,
                        Collectors.summingDouble(Presupuesto::getMonto)));

        // Agrupa los gastos por categoría y suma los montos
        Map<Categoria, Double> totalGastadoPorCategoria = gastos.stream()
                .collect(Collectors.groupingBy(Gasto::getCategoria,
                        Collectors.summingDouble(Gasto::getMonto)));

        // Combina las dos mapas anteriores para crear una lista de BalanceDto
        List<BalanceDto> balances = totalPresupuestadoPorCategoria.entrySet().stream()
                .map(entry -> {
                    Categoria categoria = entry.getKey();
                    Double montoParaGastar = entry.getValue();
                    Double montoGastado = Optional.ofNullable(totalGastadoPorCategoria.get(categoria)).orElse(0.0);
                    return BalanceDto.builder()
                            .categoria(CategoriaResponseDto.fromCategoria(categoria))
                            .montoParaGastar(montoParaGastar)
                            .montoGastado(montoGastado)
                            .build();
                })
                .collect(Collectors.toList());


        return balances;
    }
}
