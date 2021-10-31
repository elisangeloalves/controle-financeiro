package com.br.java.carteiradigital.service;

import org.springframework.security.core.Authentication;

public interface TokenService {

    public boolean isTokenValid(String token);

    public String generateToken(Authentication authentication);

    public Long getUserId(String token);
}
