package br.com.fernandoschimidt.barbearia.config;

import br.com.fernandoschimidt.barbearia.entity.UsuarioEntity;
import br.com.fernandoschimidt.barbearia.repository.UsuarioRepository;
import br.com.fernandoschimidt.barbearia.service.auth.AuthenticatonServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private AuthenticatonServiceImpl authenticatonService;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractTokenHeader(request);

        if (token != null) {
            String login = authenticatonService.validateTokenJwt(token);
            UsuarioEntity usuario = usuarioRepository.findByLogin(login);

            var authentitcation = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentitcation);
        }
        filterChain.doFilter(request, response);
    }

    public String extractTokenHeader(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
