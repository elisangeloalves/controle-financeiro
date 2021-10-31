package com.br.java.carteiradigital.controller.request;

import com.br.java.carteiradigital.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
        return new User(
                firstname,
                lastname,
                email,
                password);
    }
}
