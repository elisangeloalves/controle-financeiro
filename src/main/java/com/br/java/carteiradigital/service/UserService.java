package com.br.java.carteiradigital.service;

import com.br.java.carteiradigital.controller.request.LoginRequest;
import com.br.java.carteiradigital.controller.request.UserRequest;
import com.br.java.carteiradigital.controller.response.TokenResponse;
import com.br.java.carteiradigital.controller.response.UserResponse;
import com.br.java.carteiradigital.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.List;

public interface UserService {

    List<UserResponse> findAllByFullname(String firstname, String lastname, int page);

    List<UserResponse> findAllByFirstname(String firstname, int page);

    List<UserResponse> listUsers(List<String> request, Integer page);

    List<UserResponse> findAllByLastname(String lastname, int page);

    UserResponse findByEmail(String email);

    List<UserResponse> findAll(int page);

    User findById(Long userId);

    User update(User user);

    UserResponse createUser(UserRequest user);

    void delete(Long userId);

    TokenResponse userLogin(LoginRequest login, AuthenticationManager manager);
}
