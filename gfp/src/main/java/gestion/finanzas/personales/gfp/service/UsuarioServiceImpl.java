package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.exception.ExceptionUserNotFound;
import gestion.finanzas.personales.gfp.repository.UsuarioRepository;
import gestion.finanzas.personales.gfp.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario findByMail(String mail) {
        return usuarioRepository.findByMail(mail).orElseThrow(ExceptionUserNotFound::new);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(ExceptionUserNotFound::new);
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario usuario) {
        Usuario existingUsuario = usuarioRepository.findById(id).orElseThrow(ExceptionUserNotFound::new);
        if (existingUsuario != null) {
            existingUsuario.setMail(usuario.getMail());
            if (usuario.getPassword() != null)
                existingUsuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            return usuarioRepository.save(existingUsuario);
        }
        return null;
    }
}
