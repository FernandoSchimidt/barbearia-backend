package br.com.fernandoschimidt.barbearia.controller.auth;

import br.com.fernandoschimidt.barbearia.dto.AuthDTO;
import br.com.fernandoschimidt.barbearia.dto.UsuarioDTO;
import br.com.fernandoschimidt.barbearia.service.UsuarioService;
import br.com.fernandoschimidt.barbearia.service.auth.AuthenticatonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticatonServiceImpl authenticatonService;
    @Autowired
    private UsuarioService service;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody AuthDTO data) {

        var userAuthenticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        authenticationManager.authenticate(userAuthenticationToken);

        return authenticatonService.getToken(data);
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuario) {
        var passwordHash = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(passwordHash);
        UsuarioDTO usuarioDTO = service.create(usuario);

        return ResponseEntity.ok().body(usuarioDTO);
    }
}
