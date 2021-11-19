package com.br.java.carteiradigital.config.validation;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class ErrorDTO {

    @NonNull
    private String field;
    @NonNull
    private String message;
}
