package com.br.java.carteiradigital.controller.response;

import com.br.java.carteiradigital.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
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
        return users.stream().map(UserResponse::new).collect(Collectors.toList());
    }
}
