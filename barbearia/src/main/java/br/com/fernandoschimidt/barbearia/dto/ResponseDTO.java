package br.com.fernandoschimidt.barbearia.dto;

import br.com.fernandoschimidt.barbearia.enums.RoleEnum;

public record ResponseDTO(String email, String nome, String token, RoleEnum userRole) {
}
