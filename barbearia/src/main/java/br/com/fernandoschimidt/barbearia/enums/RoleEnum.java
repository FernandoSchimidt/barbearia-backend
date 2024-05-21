package br.com.fernandoschimidt.barbearia.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum RoleEnum {
    ADMIN("admin"),
    USER("user");

    private String role;

    RoleEnum(String role) {
        this.role = role;
    }
}
