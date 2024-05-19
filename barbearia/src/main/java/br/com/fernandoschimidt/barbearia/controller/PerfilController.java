package br.com.fernandoschimidt.barbearia.controller;

import br.com.fernandoschimidt.barbearia.dto.PerfilDTO;
import br.com.fernandoschimidt.barbearia.service.PerfiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/perfis")
public class PerfilController {

    private final PerfiService service;

    public PerfilController(PerfiService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PerfilDTO>> findAll() {
        List<PerfilDTO> perfilDTOS = service.findAll();
        return ResponseEntity.ok().body(perfilDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> findById(@PathVariable("id") Long id) {
        PerfilDTO perfilDTO = service.findById(id);
        return ResponseEntity.ok().body(perfilDTO);
    }

    @PostMapping
    public ResponseEntity<PerfilDTO> create(@RequestBody PerfilDTO usuario) {
        PerfilDTO perfilDTO = service.create(usuario);
        return ResponseEntity.ok().body(perfilDTO);
    }

    @PutMapping
    public ResponseEntity<PerfilDTO> edit(@RequestBody PerfilDTO usuario) {
        PerfilDTO perfilDTO = service.edit(usuario);
        return ResponseEntity.ok().body(perfilDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
