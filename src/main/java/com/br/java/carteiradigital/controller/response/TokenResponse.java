package com.br.java.carteiradigital.controller.response;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TokenResponse {

    @NonNull
    private String token;
    @NonNull
    private String authorizationType;
}
