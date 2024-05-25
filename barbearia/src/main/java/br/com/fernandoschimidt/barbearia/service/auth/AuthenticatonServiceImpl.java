package br.com.fernandoschimidt.barbearia.service.auth;

import br.com.fernandoschimidt.barbearia.dto.AuthDTO;
import br.com.fernandoschimidt.barbearia.entity.UsuarioEntity;
import br.com.fernandoschimidt.barbearia.repository.UsuarioRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class AuthenticatonServiceImpl implements AuthenticationService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(login);
    }

    @Override
    public String getToken(AuthDTO authDTO) {
        UsuarioEntity usuario = usuarioRepository.findByLogin(authDTO.login());
        return generateTokenJwt(usuario);
    }

    public String generateTokenJwt(UsuarioEntity usuario) {

        try {

            Algorithm algorithm = Algorithm.HMAC256("secret-api");
            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(generateTokenExpiration())
                    .sign(algorithm);

        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar o token: " + e);

        }
    }

    private Instant generateTokenExpiration() {
        return LocalDateTime.now().plusHours(12).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateTokenJwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret-api");

            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";

        }
    }
}
