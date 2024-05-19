package br.com.fernandoschimidt.barbearia.entity;

import br.com.fernandoschimidt.barbearia.dto.PerfilDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "TBL_PERFIL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilEntity {

    public PerfilEntity(PerfilDTO perfilDTO) {
        BeanUtils.copyProperties(perfilDTO, this);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;
}
