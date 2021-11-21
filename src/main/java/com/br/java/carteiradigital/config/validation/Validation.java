package com.br.java.carteiradigital.config.validation;

import com.br.java.carteiradigital.config.validation.ApiErrorException;
import com.br.java.carteiradigital.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;

@Slf4j
public class Validation {

    private Validation() {
        log.info("Tenttiva de acesso negado.");
        throw new ApiErrorException("Access Denied",
                "You don`t have permission to access this resource.",
                HttpStatus.FORBIDDEN);
    }

    public static void isUserAuthorized(Authentication authentication, Long user_id) {
        User loggedUser = (User) authentication.getPrincipal();
        if (loggedUser.getId() != user_id) new Validation();
    }

}
