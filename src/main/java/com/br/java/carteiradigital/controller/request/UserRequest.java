package com.br.java.carteiradigital.controller.request;

import com.br.java.carteiradigital.config.validation.UniqueValue;
import com.br.java.carteiradigital.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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
    @UniqueValue(domainClass = User.class, field = "email")
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
