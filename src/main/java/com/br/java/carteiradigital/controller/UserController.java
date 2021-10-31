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
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> listUsers(@RequestParam(value = "pagina", required = false) Integer page,
                                          @RequestParam(value = "nome", required = false) String firstname,
                                          @RequestParam(value = "sobrenome", required = false) String lastname,
                                          @RequestParam(value = "email", required = false) String email) {
        List<String> request = Arrays.asList(firstname, lastname, email);
        List<UserResponse> userlist = userService.listUsers(request, page);
        return new ResponseEntity<>(userlist, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest request) {
        UserResponse newUser = userService.createUser(request);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
