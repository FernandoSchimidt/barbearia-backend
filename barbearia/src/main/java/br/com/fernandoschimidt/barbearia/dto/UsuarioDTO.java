package br.com.fernandoschimidt.barbearia.dto;

import br.com.fernandoschimidt.barbearia.entity.UsuarioEntity;
import br.com.fernandoschimidt.barbearia.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    public UsuarioDTO(UsuarioEntity usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private RoleEnum role;
}
