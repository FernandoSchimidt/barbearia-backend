package br.com.fernandoschimidt.barbearia.repository;

import br.com.fernandoschimidt.barbearia.entity.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long> {
}
