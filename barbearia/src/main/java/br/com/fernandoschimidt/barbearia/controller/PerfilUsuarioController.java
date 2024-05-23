package br.com.fernandoschimidt.barbearia.controller;

import br.com.fernandoschimidt.barbearia.dto.PerfilUsuarioDTO;
import br.com.fernandoschimidt.barbearia.service.PerfilUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admin/perfil-usuario")
public class PerfilUsuarioController {
    private final PerfilUsuarioService service;

    public PerfilUsuarioController(PerfilUsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PerfilUsuarioDTO>> findAll() {
        List<PerfilUsuarioDTO> perfilDTOS = service.findAll();
        return ResponseEntity.ok().body(perfilDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilUsuarioDTO> findById(@PathVariable("id") Long id) {
        PerfilUsuarioDTO perfilDTO = service.findById(id);
        return ResponseEntity.ok().body(perfilDTO);
    }

    @PostMapping
    public ResponseEntity<PerfilUsuarioDTO> create(@RequestBody PerfilUsuarioDTO usuario) {
        PerfilUsuarioDTO perfilDTO = service.create(usuario);
        return ResponseEntity.ok().body(perfilDTO);
    }

    @PutMapping
    public ResponseEntity<PerfilUsuarioDTO> edit(@RequestBody PerfilUsuarioDTO usuario) {
        PerfilUsuarioDTO perfilDTO = service.edit(usuario);
        return ResponseEntity.ok().body(perfilDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
