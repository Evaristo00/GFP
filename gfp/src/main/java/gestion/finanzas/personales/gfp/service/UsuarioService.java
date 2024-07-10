package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.model.Usuario;

public interface UsuarioService {
    Usuario findByMail(String mail);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
    Usuario findById(Long id);
    Usuario updateUsuario(Long id, Usuario usuario);
}
