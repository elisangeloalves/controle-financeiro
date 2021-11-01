package com.br.java.carteiradigital.controller.response;


import lombok.*;

import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@Getter
public class TokenResponse {

    @NonNull
    private String token;
    @NonNull
    private String authorizationType;
}
