package com.br.java.carteiradigital.controller;

import com.br.java.carteiradigital.controller.request.UserRequest;
import com.br.java.carteiradigital.controller.response.UserResponse;
import com.br.java.carteiradigital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest request) {
        UserResponse newUser = userService.create(request);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
