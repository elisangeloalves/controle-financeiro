package com.br.java.carteiradigital.controller.response;

import com.br.java.carteiradigital.model.User;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Slf4j
public class UserResponse {

    @NonNull
    private String fullName;
    @NonNull
    private String email;
    @NonNull
    private Long id;

    public UserResponse(User user) {
        this.fullName = user.getFirstname() + " " + user.getLastname();
        this.email = user.getEmail();
        this.id = user.getId();
    }

    public static List<UserResponse> listAllUser(List<User> users) {
        return users.stream().map(UserResponse::new).toList();
    }
}
