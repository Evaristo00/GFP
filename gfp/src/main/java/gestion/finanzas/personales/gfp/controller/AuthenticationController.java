package gestion.finanzas.personales.gfp.controller;

import gestion.finanzas.personales.gfp.dto.JwtAuthenticationResponse;
import gestion.finanzas.personales.gfp.dto.SingInRequestDTO;
import gestion.finanzas.personales.gfp.dto.SingUpRequestDTO;
import gestion.finanzas.personales.gfp.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiResponse(responseCode = "403", description = "No autenticado / Token inválido", content = @Content)
@Tag(name = "Authentications")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(
            description = "Endpoint sin restricciones",
            summary = "Crea un nuevo usuario",
            responses ={
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = {
                                    @Content(schema = @Schema(implementation = JwtAuthenticationResponse.class), mediaType = "application/json")
                            }
                    )
            }
    )
    @PostMapping("/register")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody @Valid SingUpRequestDTO request) {
        return ResponseEntity.ok(authenticationService.singUp(request));
    }

    @Operation(
            description = "Endpoint sin restricciones",
            summary = "Logea un usuario creado",
            responses ={
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = {
                                    @Content(schema = @Schema(implementation = JwtAuthenticationResponse.class), mediaType = "application/json")
                            }
                    )
            }
    )
    @PostMapping("login")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody @Valid SingInRequestDTO request) {
        return ResponseEntity.ok(authenticationService.singIn(request));
    }
}
