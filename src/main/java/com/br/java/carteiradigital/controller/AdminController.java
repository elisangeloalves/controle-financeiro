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
@RequestMapping("/management")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> listUsers(@RequestParam(required = false) Integer page,
                                          @RequestParam(required = false) String firstname,
                                          @RequestParam(required = false) String lastname,
                                          @RequestParam(required = false) String email) {
        List<String> request = Arrays.asList(firstname, lastname, email);
        List<UserResponse> userlist = userService.listUsers(request, page);
        return new ResponseEntity<>(userlist, HttpStatus.OK);
    }
}
