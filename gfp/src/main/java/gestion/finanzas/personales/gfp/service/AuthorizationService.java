package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.exception.ExceptionUserNotFound;
import gestion.finanzas.personales.gfp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    private UsuarioRepository userRepository;

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByMail(username)
                        .orElseThrow(() -> new ExceptionUserNotFound());
            }
        };
    }
}