package gestion.finanzas.personales.gfp.service;

import gestion.finanzas.personales.gfp.dto.JwtAuthenticationResponse;
import gestion.finanzas.personales.gfp.dto.SingInRequestDTO;
import gestion.finanzas.personales.gfp.dto.SingUpRequestDTO;
import gestion.finanzas.personales.gfp.dto.UsuarioResponse;
import gestion.finanzas.personales.gfp.exception.ExceptionUserAlreadyExist;
import gestion.finanzas.personales.gfp.model.Usuario;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsuarioService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationResponse singUp(SingUpRequestDTO singUpRequestDTO){

        Usuario user = userService.findByMail(singUpRequestDTO.email());
        if (user != null){
            throw new ExceptionUserAlreadyExist();
        }

        Usuario savedUser = Usuario.builder()
                    .mail(singUpRequestDTO.email())
                    .password(passwordEncoder.encode(singUpRequestDTO.password()))
                    .build();

        savedUser = userService.save(savedUser);

        String jwt = jwtService.generateToken(savedUser);

        return JwtAuthenticationResponse.builder().token(jwt)
                .user(UsuarioResponse.builder().mail(savedUser.getMail()).id(savedUser.getId()).build()).build();
    }

    public JwtAuthenticationResponse singIn(SingInRequestDTO request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(),request.password()));
        Usuario user = userService.findByMail(request.email());
        String jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt)
                .user(UsuarioResponse.builder().mail(user.getMail()).id(user.getId()).build()).build();
    }



}
