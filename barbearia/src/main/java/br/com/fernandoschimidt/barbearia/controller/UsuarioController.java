package br.com.fernandoschimidt.barbearia.controller;

import br.com.fernandoschimidt.barbearia.dto.UsuarioDTO;
import br.com.fernandoschimidt.barbearia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> usuarioDTOS = service.findAll();
        return ResponseEntity.ok().body(usuarioDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable("id") Long id) {
        UsuarioDTO usuarioDTO = service.findById(id);
        return ResponseEntity.ok().body(usuarioDTO);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuario) {
        var passwordHash = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(passwordHash);
        UsuarioDTO usuarioDTO = service.create(usuario);

        return ResponseEntity.ok().body(usuarioDTO);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> edit(@RequestBody UsuarioDTO usuario) {
        var passwordHash = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(passwordHash);
        UsuarioDTO usuarioDTO = service.edit(usuario);
        return ResponseEntity.ok().body(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
