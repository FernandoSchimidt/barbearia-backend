package br.com.fernandoschimidt.barbearia.service;

import br.com.fernandoschimidt.barbearia.dto.RecursoDTO;
import br.com.fernandoschimidt.barbearia.entity.RecursoEntity;
import br.com.fernandoschimidt.barbearia.repository.RecursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService {
    private final RecursoRepository repository;

    public RecursoService(RecursoRepository repository) {
        this.repository = repository;
    }

    public List<RecursoDTO> findAll() {
        List<RecursoEntity> recursos = repository.findAll();
        return recursos.stream().map(RecursoDTO::new).toList();
    }

    public RecursoDTO create(RecursoDTO usuario) {
        RecursoEntity recursoEntity = new RecursoEntity(usuario);
        return new RecursoDTO(repository.save(recursoEntity));
    }

    public RecursoDTO edit(RecursoDTO usuario) {
        RecursoEntity usuarioEntity = new RecursoEntity(usuario);
        return new RecursoDTO(repository.save(usuarioEntity));
    }

    public void delete(Long id) {
        RecursoEntity recurso = repository.findById(id).get();
        repository.delete(recurso);

    }

    public RecursoDTO findById(Long id) {
        return new RecursoDTO(repository.findById(id).get());


    }
}
