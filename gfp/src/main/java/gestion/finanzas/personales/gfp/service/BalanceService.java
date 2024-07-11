package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.dto.BalanceDto;
import gestion.finanzas.personales.gfp.model.Usuario;

import java.util.List;

public interface BalanceService {

    List<BalanceDto> listBalances(Usuario usuario);
}
