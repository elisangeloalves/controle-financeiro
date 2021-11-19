package com.br.java.carteiradigital.controller.request;

import com.br.java.carteiradigital.model.User;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@Getter
public class UserRequest {

    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public User toModel() {
        String encryptedPassword = new BCryptPasswordEncoder().encode(password);
        return new User(
                firstname.toUpperCase(),
                lastname.toUpperCase(),
                email,
                encryptedPassword);
    }
}
