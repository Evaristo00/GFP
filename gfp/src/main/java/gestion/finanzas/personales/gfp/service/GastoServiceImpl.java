package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.exception.ExceptionUserNotAuthorized;
import gestion.finanzas.personales.gfp.model.Usuario;
import gestion.finanzas.personales.gfp.repository.GastoRepository;
import gestion.finanzas.personales.gfp.model.Gasto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GastoServiceImpl implements GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Override
    public List<Gasto> findByUsuarioId(Long usuarioId) {
        return gastoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Gasto> findByCategoriaId(Long categoriaId, Usuario usuario) {

        return gastoRepository.findByUsuarioIdAndCategoriaId(usuario.getId(),categoriaId);
    }

    @Override
    public Gasto save(Gasto gasto, Usuario usuario) {
        gasto.setUsuario(usuario);
        return gastoRepository.save(gasto);
    }

    @Override
    public void deleteById(Long id, Usuario usuario) {
        Optional<Gasto> gasto = gastoRepository.findByUsuarioIdAndId(usuario.getId(),id);
        if (gasto.isPresent() && !gasto.get().getUsuario().getId().equals(usuario.getId())){
            throw new ExceptionUserNotAuthorized();
        }
        gastoRepository.deleteById(id);
    }

}