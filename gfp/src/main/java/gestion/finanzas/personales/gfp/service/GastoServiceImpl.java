package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.repository.GastoRepository;
import gestion.finanzas.personales.gfp.model.Gasto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoServiceImpl implements GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Override
    public List<Gasto> findByUsuarioId(Long usuarioId) {
        return gastoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Gasto> findByCategoriaId(Long categoriaId) {
        return gastoRepository.findByCategoriaId(categoriaId);
    }

    @Override
    public Gasto save(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    @Override
    public void deleteById(Long id) {
        gastoRepository.deleteById(id);
    }

    @Override
    public Gasto findById(Long id) {
        return gastoRepository.findById(id).orElse(null);
    }
}