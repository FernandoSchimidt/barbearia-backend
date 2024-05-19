package br.com.fernandoschimidt.barbearia.dto;

import br.com.fernandoschimidt.barbearia.entity.PerfilEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilDTO {

    public PerfilDTO(PerfilEntity perfil) {
        BeanUtils.copyProperties(perfil, this);
    }

    private Long id;
    private String descricao;
}
