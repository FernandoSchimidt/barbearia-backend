package br.com.fernandoschimidt.barbearia.security.auth;

import br.com.fernandoschimidt.barbearia.dto.AuthenticationDTO;
import br.com.fernandoschimidt.barbearia.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    public AcessDTO login(AuthenticationDTO authenticationDTO){
        UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(),authenticationDTO.getPassword());

        Authentication authentication = authenticationManager.authenticate(userAuth);

        UserDetailsImpl userAuthenticate = (UserDetailsImpl).authentication.getPrincipal();
    }
}
