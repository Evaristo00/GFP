package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.dto.CategoriaResponseDto;
import gestion.finanzas.personales.gfp.dto.GastosRequestDto;
import gestion.finanzas.personales.gfp.dto.GastosResponseDto;
import gestion.finanzas.personales.gfp.exception.ExceptionCategoriaNotFound;
import gestion.finanzas.personales.gfp.exception.ExceptionUserNotAuthorized;
import gestion.finanzas.personales.gfp.model.Categoria;
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

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public List<Gasto> findByUsuarioId(Long usuarioId) {
        return gastoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Gasto> findByCategoriaId(Long categoriaId, Usuario usuario) {

        return gastoRepository.findByUsuarioIdAndCategoriaId(usuario.getId(),categoriaId);
    }

    @Override
    public GastosResponseDto save(GastosRequestDto gastosRequestDto, Usuario usuario) {
        Categoria categoria =categoriaService.findById(gastosRequestDto.idCategoria());
        if (categoria == null) {
            throw new ExceptionCategoriaNotFound();
        }
        Gasto gasto = Gasto.builder()
                .monto(gastosRequestDto.monto())
                .usuario(usuario)
                .categoria(categoria)
                .build();
        gasto = gastoRepository.save(gasto);

        return GastosResponseDto.builder()
                .categoria(CategoriaResponseDto.fromCategoria(gasto.getCategoria()))
                .build().fromGasto(gasto);
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