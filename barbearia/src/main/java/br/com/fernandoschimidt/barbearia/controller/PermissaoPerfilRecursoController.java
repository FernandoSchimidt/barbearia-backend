package br.com.fernandoschimidt.barbearia.controller;

import br.com.fernandoschimidt.barbearia.dto.PermissaoPerfilRecursoDTO;
import br.com.fernandoschimidt.barbearia.service.PermissaoPerfilRecursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admin/permissao-perfil")
public class PermissaoPerfilRecursoController {
    private final PermissaoPerfilRecursoService service;

    public PermissaoPerfilRecursoController(PermissaoPerfilRecursoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PermissaoPerfilRecursoDTO>> findAll() {
        List<PermissaoPerfilRecursoDTO> perfilDTOS = service.findAll();
        return ResponseEntity.ok().body(perfilDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissaoPerfilRecursoDTO> findById(@PathVariable("id") Long id) {
        PermissaoPerfilRecursoDTO perfilDTO = service.findById(id);
        return ResponseEntity.ok().body(perfilDTO);
    }

    @PostMapping
    public ResponseEntity<PermissaoPerfilRecursoDTO> create(@RequestBody PermissaoPerfilRecursoDTO usuario) {
        PermissaoPerfilRecursoDTO perfilDTO = service.create(usuario);
        return ResponseEntity.ok().body(perfilDTO);
    }

    @PutMapping
    public ResponseEntity<PermissaoPerfilRecursoDTO> edit(@RequestBody PermissaoPerfilRecursoDTO usuario) {
        PermissaoPerfilRecursoDTO perfilDTO = service.edit(usuario);
        return ResponseEntity.ok().body(perfilDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
