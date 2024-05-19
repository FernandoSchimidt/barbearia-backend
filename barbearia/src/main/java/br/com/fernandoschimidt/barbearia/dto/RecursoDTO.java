package br.com.fernandoschimidt.barbearia.dto;

import br.com.fernandoschimidt.barbearia.entity.RecursoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecursoDTO {

    public RecursoDTO(RecursoEntity recurso){
        BeanUtils.copyProperties(recurso, this);
    }
    private Long id;
    private String nome;
    private String chave;
}
