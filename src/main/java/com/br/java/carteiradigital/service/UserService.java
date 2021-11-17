package com.br.java.carteiradigital.service;

import com.br.java.carteiradigital.controller.request.LoginRequest;
import com.br.java.carteiradigital.controller.request.UserRequest;
import com.br.java.carteiradigital.controller.response.TokenResponse;
import com.br.java.carteiradigital.controller.response.UserResponse;
import com.br.java.carteiradigital.model.User;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.List;

public interface UserService {

    List<UserResponse> findAllByFullname(String firstname, String lastname, int page);

    TokenResponse login(LoginRequest login, AuthenticationManager manager);

    List<UserResponse> findAllByFirstname(String firstname, int page);

    List<UserResponse> listUsers(List<String> request, Integer page);

    List<UserResponse> findAllByLastname(String lastname, int page);

    UserResponse findByEmail(String email);

    UserResponse create(UserRequest user);

    List<UserResponse> findAll(int page);

    User findById(Long userId);

    void delete(Long userId);

    UserResponse update(User user);
}
