package com.br.java.carteiradigital.controller;


import com.br.java.carteiradigital.controller.request.CategoryRequest;
import com.br.java.carteiradigital.controller.response.CategoryResponse;
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
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> lisCategories() {
        return new ResponseEntity<>(categoryService.listCategories(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(
            @RequestBody @Valid CategoryRequest request,
            UriComponentsBuilder uriBuilder,
            Authentication authentication
    ) {
        CategoryResponse newCategory = categoryService.createCategory(request.toModel());
        URI uri = uriBuilder.path("/categories/{id}").buildAndExpand(newCategory.getId()).toUri();
        return ResponseEntity.created(uri)
                .body(newCategory);
    }
}
