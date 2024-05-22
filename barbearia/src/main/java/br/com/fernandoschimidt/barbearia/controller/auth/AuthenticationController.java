package br.com.fernandoschimidt.barbearia.controller.auth;

import br.com.fernandoschimidt.barbearia.dto.AuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody AuthDTO data) {

        var userAuthenticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        authenticationManager.authenticate(userAuthenticationToken);

        return "TESTE";
    }
}
