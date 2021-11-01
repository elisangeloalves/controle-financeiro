package com.br.java.carteiradigital.controller.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.Email;

@RequiredArgsConstructor
@Getter
public class LoginRequest {

    @NonNull
    @Email
    private String email;
    @NonNull
    private String password;

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
