package br.com.fernandoschimidt.barbearia.repository;

import br.com.fernandoschimidt.barbearia.entity.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {
}
