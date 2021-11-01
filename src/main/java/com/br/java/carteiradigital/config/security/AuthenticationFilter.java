package com.br.java.carteiradigital.config.security;

import com.br.java.carteiradigital.model.User;
import com.br.java.carteiradigital.service.TokenService;
import com.br.java.carteiradigital.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UserService userService;

    public AuthenticationFilter(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = this.restoreToken(request);
        boolean tokenIsValid = tokenService.isTokenValid(token);

        if (tokenIsValid) {
            this.setUserAuthenticated(token);
        }
        filterChain.doFilter(request, response);
    }

    private String restoreToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7);
    }

    private void setUserAuthenticated(String token) {
        Long id = tokenService.getUserId(token);
        User authorizedUser = userService.findById(id);
        UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                authorizedUser,
                null,
                authorizedUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(credentials);
    }
}
