package com.br.java.carteiradigital.controller.request;

import com.br.java.carteiradigital.model.User;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@Getter
public class UserRequest {

    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    @NonNull
    private String email;
    @NonNull
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
