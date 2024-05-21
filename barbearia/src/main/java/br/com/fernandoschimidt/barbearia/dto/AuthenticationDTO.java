package br.com.fernandoschimidt.barbearia.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDTO {
    private String username;
    private String password;
}
