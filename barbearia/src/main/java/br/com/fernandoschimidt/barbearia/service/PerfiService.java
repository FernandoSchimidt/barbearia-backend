package br.com.fernandoschimidt.barbearia.service;

import br.com.fernandoschimidt.barbearia.dto.PerfilDTO;
import br.com.fernandoschimidt.barbearia.entity.PerfilEntity;
import br.com.fernandoschimidt.barbearia.repository.PerfilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfiService {

    private final PerfilRepository repository;

    public PerfiService(PerfilRepository repository) {
        this.repository = repository;
    }

    public List<PerfilDTO> findAll() {
        List<PerfilEntity> perfil = repository.findAll();
        return perfil.stream().map(PerfilDTO::new).toList();
    }

    public PerfilDTO create(PerfilDTO usuario) {
        PerfilEntity perfilEntity = new PerfilEntity(usuario);
        return new PerfilDTO(repository.save(perfilEntity));
    }

    public PerfilDTO edit(PerfilDTO usuario) {
        PerfilEntity perfilEntity = new PerfilEntity(usuario);
        return new PerfilDTO(repository.save(perfilEntity));
    }

    public void delete(Long id) {
        PerfilEntity perfil = repository.findById(id).get();
        repository.delete(perfil);

    }

    public PerfilDTO findById(Long id) {
        return new PerfilDTO(repository.findById(id).get());
    }
}
