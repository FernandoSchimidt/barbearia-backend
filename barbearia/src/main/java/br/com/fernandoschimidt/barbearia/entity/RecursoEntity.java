package br.com.fernandoschimidt.barbearia.entity;

import br.com.fernandoschimidt.barbearia.dto.RecursoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "TBL_RECURSO")
@Getter
@Setter
public class RecursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String chave;

    public RecursoEntity(RecursoDTO recursoDTO) {
        BeanUtils.copyProperties(recursoDTO, this);
    }

    public RecursoEntity(Long id, String nome, String chave) {
        this.id = id;
        this.nome = nome;
        this.chave = chave;
    }

    public RecursoEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecursoEntity that = (RecursoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
