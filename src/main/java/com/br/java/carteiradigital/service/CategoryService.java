package com.br.java.carteiradigital.service;

import com.br.java.carteiradigital.controller.response.CategoryResponse;
import com.br.java.carteiradigital.model.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> listCategories();
    CategoryResponse createCategory(Category newCategory);
}
