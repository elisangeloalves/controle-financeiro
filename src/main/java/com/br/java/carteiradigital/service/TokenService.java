package com.br.java.carteiradigital.service;

import org.springframework.security.core.Authentication;

public interface TokenService {

    boolean isTokenValid(String token);

    String generateToken(Authentication authentication);

    Long getUserId(String token);
}
