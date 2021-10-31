package com.br.java.carteiradigital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-word")
public class HelloWordController {

    @GetMapping
    public ResponseEntity<String> sayHello(@RequestParam(value = "name", required = false) String nome) {
        return new ResponseEntity<>("Ola " + nome, HttpStatus.OK);
    }
}
