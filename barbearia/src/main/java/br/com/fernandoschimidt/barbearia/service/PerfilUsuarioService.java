package br.com.fernandoschimidt.barbearia.service;
import br.com.fernandoschimidt.barbearia.dto.PerfilUsuarioDTO;
import br.com.fernandoschimidt.barbearia.entity.PerfilUsuarioEntity;
import br.com.fernandoschimidt.barbearia.repository.PerfilUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioService {

    private final PerfilUsuarioRepository repository;

    public PerfilUsuarioService(PerfilUsuarioRepository repository) {
        this.repository = repository;
    }

    public List<PerfilUsuarioDTO> findAll() {
        List<PerfilUsuarioEntity> perfil = repository.findAll();
        return perfil.stream().map(PerfilUsuarioDTO::new).toList();
    }

    public PerfilUsuarioDTO create(PerfilUsuarioDTO usuario) {
        PerfilUsuarioEntity perfilEntity = new PerfilUsuarioEntity(usuario);
        return new PerfilUsuarioDTO(repository.save(perfilEntity));
    }

    public PerfilUsuarioDTO edit(PerfilUsuarioDTO usuario) {
        PerfilUsuarioEntity perfilEntity = new PerfilUsuarioEntity(usuario);
        return new PerfilUsuarioDTO(repository.save(perfilEntity));
    }

    public void delete(Long id) {
        PerfilUsuarioEntity perfil = repository.findById(id).get();
        repository.delete(perfil);

    }

    public PerfilUsuarioDTO findById(Long id) {
        return new PerfilUsuarioDTO(repository.findById(id).get());
    }
}
