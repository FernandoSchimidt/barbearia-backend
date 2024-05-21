package br.com.fernandoschimidt.barbearia.security.jwt;

import br.com.fernandoschimidt.barbearia.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    @Value("${projeto.jwtSecret}")
    private String jwtSecret;

    @Value("${projeto.jwtExpirationMs}")
    private int JwtExpiratonMs;

    public String generatetokenFromUserDetailsImpl(UserDetailsImpl userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + JwtExpiratonMs))
                .signWith(getSigninKey(), SignatureAlgorithm.ES512).compact();
    }

    public Key getSigninKey() {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        return key;
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            System.out.println("Token invalido " + e.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println("Token expirado " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("Token nao suportado " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Token argumento invalido " + e.getMessage());
        }
        return false;
    }
}
