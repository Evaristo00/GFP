package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.repository.PresupuestoRepository;
import gestion.finanzas.personales.gfp.model.Presupuesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresupuestoServiceImpl implements PresupuestoService {

    @Autowired
    private PresupuestoRepository presupuestoRepository;

    @Override
    public List<Presupuesto> findByUsuarioId(Long usuarioId) {
        return presupuestoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public Presupuesto save(Presupuesto presupuesto) {
        return presupuestoRepository.save(presupuesto);
    }

    @Override
    public void deleteById(Long id) {
        presupuestoRepository.deleteById(id);
    }

    @Override
    public Presupuesto findById(Long id) {
        return presupuestoRepository.findById(id).orElse(null);
    }
}