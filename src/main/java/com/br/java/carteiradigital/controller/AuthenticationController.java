package com.br.java.carteiradigital.controller;

import com.br.java.carteiradigital.controller.request.LoginRequest;
import com.br.java.carteiradigital.controller.response.TokenResponse;
import com.br.java.carteiradigital.model.User;
import com.br.java.carteiradigital.service.TokenService;
import com.br.java.carteiradigital.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    private final UserService userService;

    private final AuthenticationManager manager;

    public AuthenticationController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.manager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<TokenResponse> userLogin(@RequestBody @Valid LoginRequest request) {
        return new ResponseEntity<>(userService.userLogin(request, manager), HttpStatus.OK);
    }
}
