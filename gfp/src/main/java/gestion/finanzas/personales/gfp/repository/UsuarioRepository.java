package gestion.finanzas.personales.gfp.repository;

import gestion.finanzas.personales.gfp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByMail(String mail);
}
