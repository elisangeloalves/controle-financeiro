package com.br.java.carteiradigital.service.serviceimpl;

import com.br.java.carteiradigital.model.User;
import com.br.java.carteiradigital.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
@Slf4j
public class JwtsTokenServiceImpl implements TokenService {

    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final int EXPIRATION_TIME = 30000;

    @Override
    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(JwtsTokenServiceImpl.SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch(JwtException e){
            log.info("Erro na validacao do token: "+e.getMessage());
            return false;
        }
    }

    @Override
    public String generateToken(Authentication authentication) {
        Date today = new Date();
        Date dueDate = new Date(today.getTime() + EXPIRATION_TIME);
        User user = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setIssuer("API carteira digital - author: Elisangelo")     // quem emitiu o token
                .setSubject(user.getId().toString())    // informacao que identifica o usuario no banco de dados
                .setIssuedAt(today)     // data de emissao do token
                .setExpiration(dueDate)     // data de expiração do token
                .signWith(SECRET_KEY)      // chave pra assinar o token tornando um confiavel e seguro
                .compact();     // comprime a string final
    }

    @Override
    public Long getUserId(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(JwtsTokenServiceImpl.SECRET_KEY)
                .build().parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }
}
