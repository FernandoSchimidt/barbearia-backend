package br.com.fernandoschimidt.barbearia.controller.auth;

import br.com.fernandoschimidt.barbearia.dto.AuthenticationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authenticationDTO){

    }
}
