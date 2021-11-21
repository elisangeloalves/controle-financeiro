package com.br.java.carteiradigital.controller;


import com.br.java.carteiradigital.config.validation.ApiErrorException;
import com.br.java.carteiradigital.config.validation.Validation;
import com.br.java.carteiradigital.controller.request.CategoryRequest;
import com.br.java.carteiradigital.controller.response.CategoryResponse;
import com.br.java.carteiradigital.model.User;
import com.br.java.carteiradigital.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users/{user_id}/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> lisCategories(Authentication authentication,
                                                                @PathVariable Long user_id) {
        Validation.isUserAuthorized(authentication, user_id);
        return new ResponseEntity<>(categoryService.listCategories(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(
            @RequestBody @Valid CategoryRequest request,
            UriComponentsBuilder uriBuilder,
            Authentication authentication,
            @PathVariable Long user_id
    ) {
        Validation.isUserAuthorized(authentication, user_id);
        CategoryResponse newCategory = categoryService.createCategory(request.toModel());

        URI uri = uriBuilder.path("users/{user_id}/categories/{id}")
                .buildAndExpand(user_id,  newCategory.getId()).toUri();
        return ResponseEntity.created(uri)
                .body(newCategory);
    }
}
