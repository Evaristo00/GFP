package gestion.finanzas.personales.gfp.repository;

import gestion.finanzas.personales.gfp.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {
    List<Gasto> findByUsuarioId(Long usuarioId);
    List<Gasto> findByCategoriaId(Long categoriaId);
}