package com.br.java.carteiradigital.config.validation;

import com.br.java.carteiradigital.config.validation.ApiErrorException;
import com.br.java.carteiradigital.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;

public class Validation {

    private Validation() {
        throw new ApiErrorException("Access Denied",
                "You don`t have permission to access this resource.",
                HttpStatus.FORBIDDEN);
    }

    public static void isUserAuthorized(Authentication authentication, Long user_id) {
        User loggedUser = (User) authentication.getPrincipal();
        if (loggedUser.getId() != user_id) new Validation();
    }

}
