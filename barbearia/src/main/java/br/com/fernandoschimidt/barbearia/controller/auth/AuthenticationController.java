package br.com.fernandoschimidt.barbearia.controller.auth;

import br.com.fernandoschimidt.barbearia.dto.AuthDTO;
import br.com.fernandoschimidt.barbearia.dto.ResponseDTO;
import br.com.fernandoschimidt.barbearia.dto.UsuarioDTO;
import br.com.fernandoschimidt.barbearia.entity.UsuarioEntity;
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
    public ResponseEntity login(@RequestBody AuthDTO body) {
        UsuarioEntity usuario = service.findByLogin(body.login());
        if (passwordEncoder.matches(body.senha(), usuario.getPassword())) {
            String token = this.authenticatonService.getToken(body);
            return ResponseEntity.ok(new ResponseDTO(usuario.getEmail(), usuario.getNome(), token, usuario.getRole()));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuario) {
        var passwordHash = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(passwordHash);
        UsuarioDTO usuarioDTO = service.create(usuario);

        return ResponseEntity.ok().body(usuarioDTO);
    }
}
