package com.br.java.carteiradigital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWordController {

    @GetMapping
    public ResponseEntity<String> sayHello(@RequestParam(value = "name", required = false) String name) {
        name = name == null ? "mundo": name;
        return new ResponseEntity<>("Ola "+name+"!", HttpStatus.OK);
    }
}
