package com.br.java.carteiradigital.controller.request;

import com.br.java.carteiradigital.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@NoArgsConstructor
@Data
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
