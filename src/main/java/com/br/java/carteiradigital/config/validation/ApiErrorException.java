package com.br.java.carteiradigital.config.validation;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
@Slf4j
public class ApiErrorException extends RuntimeException{

    @NonNull
    private final String error;
    @NonNull
    private final String message;
    @NonNull
    private final HttpStatus status;

    @Override
    public String getLocalizedMessage() {
        return message;
    }
}
