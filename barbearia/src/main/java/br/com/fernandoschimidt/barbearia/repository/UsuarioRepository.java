package br.com.fernandoschimidt.barbearia.repository;

import br.com.fernandoschimidt.barbearia.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    UsuarioEntity findByLogin(String username);

}
