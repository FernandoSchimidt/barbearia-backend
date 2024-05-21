package br.com.fernandoschimidt.barbearia.service;

import br.com.fernandoschimidt.barbearia.dto.PermissaoPerfilRecursoDTO;
import br.com.fernandoschimidt.barbearia.entity.PermissaoPerfilRecursoEntity;
import br.com.fernandoschimidt.barbearia.repository.PermissaoPerfilRecursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoPerfilRecursoService {
    private final PermissaoPerfilRecursoRepository repository;

    public PermissaoPerfilRecursoService(PermissaoPerfilRecursoRepository repository) {
        this.repository = repository;
    }


    public List<PermissaoPerfilRecursoDTO> findAll() {
        List<PermissaoPerfilRecursoEntity> perfil = repository.findAll();
        return perfil.stream().map(PermissaoPerfilRecursoDTO::new).toList();
    }

    public PermissaoPerfilRecursoDTO create(PermissaoPerfilRecursoDTO usuario) {
        PermissaoPerfilRecursoEntity perfilEntity = new PermissaoPerfilRecursoEntity(usuario);
        return new PermissaoPerfilRecursoDTO(repository.save(perfilEntity));
    }

    public PermissaoPerfilRecursoDTO edit(PermissaoPerfilRecursoDTO usuario) {
        PermissaoPerfilRecursoEntity perfilEntity = new PermissaoPerfilRecursoEntity(usuario);
        return new PermissaoPerfilRecursoDTO(repository.save(perfilEntity));
    }

    public void delete(Long id) {
        PermissaoPerfilRecursoEntity perfil = repository.findById(id).get();
        repository.delete(perfil);

    }

    public PermissaoPerfilRecursoDTO findById(Long id) {
        return new PermissaoPerfilRecursoDTO(repository.findById(id).get());
    }
}
