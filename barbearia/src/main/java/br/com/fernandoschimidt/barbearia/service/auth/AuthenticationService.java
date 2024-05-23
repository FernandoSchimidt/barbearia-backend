package br.com.fernandoschimidt.barbearia.service.auth;

import br.com.fernandoschimidt.barbearia.dto.AuthDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService extends UserDetailsService {
    public String getToken(AuthDTO authDTO);
}
