package com.br.java.carteiradigital.service.serviceimpl;

import com.br.java.carteiradigital.controller.response.CategoryResponse;
import com.br.java.carteiradigital.model.Category;
import com.br.java.carteiradigital.repository.CategoryRepository;
import com.br.java.carteiradigital.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponse> listCategories() {
        List<Category> categories = categoryRepository.findAll();
        return CategoryResponse.listCategories(categories);
    }

    @Override
    public CategoryResponse createCategory(Category category) {
        Category newCategory = categoryRepository.save(category);
        return new CategoryResponse(newCategory);
    }
}
