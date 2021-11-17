package com.br.java.carteiradigital.service;

import org.springframework.security.core.Authentication;

public interface TokenService {

    String generateToken(Authentication authentication);

    boolean isTokenValid(String token);

    Long getUserId(String token);
}
