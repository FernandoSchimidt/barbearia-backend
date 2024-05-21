package br.com.fernandoschimidt.barbearia.repository;

import br.com.fernandoschimidt.barbearia.entity.PerfilUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioEntity, Long> {
}
