package br.com.fernandoschimidt.barbearia.service;

import br.com.fernandoschimidt.barbearia.dto.UsuarioDTO;
import br.com.fernandoschimidt.barbearia.entity.UsuarioEntity;
import br.com.fernandoschimidt.barbearia.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioDTO> findAll() {
        List<UsuarioEntity> usuarios = repository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    public UsuarioDTO create(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        return new UsuarioDTO(repository.save(usuarioEntity));
    }

    public UsuarioDTO edit(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        return new UsuarioDTO(repository.save(usuarioEntity));
    }

    public void delete(Long id) {
        UsuarioEntity usuario = repository.findById(id).get();
        repository.delete(usuario);

    }

    public UsuarioDTO findById(Long id) {
        return new UsuarioDTO(repository.findById(id).get());


    }
}
