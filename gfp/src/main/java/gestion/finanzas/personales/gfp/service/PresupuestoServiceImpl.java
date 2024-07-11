package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.dto.PresupuestoRequestDto;
import gestion.finanzas.personales.gfp.dto.PresupuestoResponseDto;
import gestion.finanzas.personales.gfp.exception.ExceptionCategoriaNotFound;
import gestion.finanzas.personales.gfp.exception.ExceptionPresupuestoNotFound;
import gestion.finanzas.personales.gfp.model.Categoria;
import gestion.finanzas.personales.gfp.model.Usuario;
import gestion.finanzas.personales.gfp.repository.PresupuestoRepository;
import gestion.finanzas.personales.gfp.model.Presupuesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PresupuestoServiceImpl implements PresupuestoService {

    @Autowired
    private PresupuestoRepository presupuestoRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public List<Presupuesto> findByUsuarioId(Long usuarioId) {
        return presupuestoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public PresupuestoResponseDto save(PresupuestoRequestDto presupuestoRequestDto, Usuario usuario) {
        Categoria categoria = categoriaService.findById(presupuestoRequestDto.idCategoria());
        if(Objects.isNull(categoria)) throw new ExceptionCategoriaNotFound();
        Presupuesto presupuesto = Presupuesto.builder()
                .mes(presupuestoRequestDto.mes())
                .categoria(categoria)
                .monto(presupuestoRequestDto.monto())
                .usuario(usuario)
                .build();
        Presupuesto presupuestoSaved =  presupuestoRepository.save(presupuesto);
        return PresupuestoResponseDto.fromPresupuesto(presupuestoSaved);
    }

    @Override
    public void deleteById(Long id,Usuario usuario) {
        Presupuesto presupuesto = presupuestoRepository.findById(id).orElseThrow(ExceptionPresupuestoNotFound::new);
        if (presupuesto.getUsuario().getId().equals(usuario.getId())) {
            throw new ExceptionPresupuestoNotFound();
        }
        presupuestoRepository.deleteById(id);
    }

    @Override
    public Presupuesto findById(Long id, Usuario usuario) {

        Presupuesto presupuesto =  presupuestoRepository.findById(id).orElseThrow(ExceptionPresupuestoNotFound::new);
        boolean perteneceAlUsuacio = Objects.equals(presupuesto.getUsuario().getId(),usuario.getId());
        if (!perteneceAlUsuacio){
            throw new ExceptionPresupuestoNotFound();
        }
        return presupuesto;
    }
}