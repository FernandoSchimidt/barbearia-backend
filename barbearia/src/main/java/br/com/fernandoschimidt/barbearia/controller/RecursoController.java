package br.com.fernandoschimidt.barbearia.controller;

import br.com.fernandoschimidt.barbearia.dto.RecursoDTO;
import br.com.fernandoschimidt.barbearia.service.RecursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admin/recursos")
public class RecursoController {

    private final RecursoService service;

    public RecursoController(RecursoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RecursoDTO>> findAll() {
        List<RecursoDTO> recursoDTOS = service.findAll();
        return ResponseEntity.ok().body(recursoDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecursoDTO> findById(@PathVariable("id") Long id) {
        RecursoDTO recursoDTO = service.findById(id);
        return ResponseEntity.ok().body(recursoDTO);
    }

    @PostMapping
    public ResponseEntity<RecursoDTO> create(@RequestBody RecursoDTO usuario) {
        RecursoDTO recursoDTO = service.create(usuario);
        return ResponseEntity.ok().body(recursoDTO);
    }

    @PutMapping
    public ResponseEntity<RecursoDTO> edit(@RequestBody RecursoDTO usuario) {
        RecursoDTO recursoDTO = service.edit(usuario);
        return ResponseEntity.ok().body(recursoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
